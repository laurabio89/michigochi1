package com.example.michigochi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView paddle, ball;
    private int paddleWidth, screenWidth;
    private float ballX, ballY, ballSpeedX, ballSpeedY;
    private final int FRAME_RATE = 30;
    private Handler handler;
    private float initialX; // Variable para guardar la posición inicial del toque

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paddle = findViewById(R.id.paddle);
        ball = findViewById(R.id.ball);
        handler = new Handler();

        paddle.post(new Runnable() {
            @Override
            public void run() {
                paddleWidth = paddle.getWidth();
                screenWidth = getWindowManager().getDefaultDisplay().getWidth();
                ballX = ball.getX();
                ballY = ball.getY();
                ballSpeedX = 10;
                ballSpeedY = 10;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        moveBall(); // Aquí llamamos al método moveBall
                    }
                }, FRAME_RATE);
            }
        });

        // Agregar listener para el movimiento del paddle con el ratón
        paddle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        movePaddle((int) event.getX()); // Movemos el paddle a la posición del ratón
                        return true; // Indicamos que hemos manejado el evento
                    default:
                        return false; // No hacemos nada para otros tipos de eventos
                }
            }
        });
    }

    private void moveBall() {
        // Actualizar la posición de la pelota
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Verificar colisiones con los bordes de la pantalla
        if (ballX <= 0 || ballX >= screenWidth - ball.getWidth()) {
            ballSpeedX = -ballSpeedX; // Invertir la dirección horizontal
        }
        if (ballY <= 0 || ballY >= paddle.getY() - ball.getHeight()) {
            ballSpeedY = -ballSpeedY; // Invertir la dirección vertical
        }

        // Actualizar la posición de la pelota en la pantalla
        ball.setX(ballX);
        ball.setY(ballY);

        // Programar el siguiente movimiento de la pelota
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveBall(); // Llamar de nuevo al método para mover la pelota
            }
        }, FRAME_RATE);
    }

    private void movePaddle(int x) {
        float newX = x - (paddleWidth / 2);
        if (newX < 0) {
            newX = 0;
        } else if (newX + paddleWidth > screenWidth) {
            newX = screenWidth - paddleWidth;
        }
        paddle.setX(newX);
    }
}
