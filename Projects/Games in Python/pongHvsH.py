# Rishav Nath Pati
# Pong game revisited

import turtle
import time

window_panel = turtle.Screen()
window_panel.title("PONG by Rishav")
window_panel.bgcolor("black")
window_panel.setup(width=800, height=600)
window_panel.tracer(0)
score_a = 0
score_b = 0

# Paddle A
paddle_a = turtle.Turtle()
paddle_a.speed(0)
paddle_a.shape("square")
paddle_a.color("white")
paddle_a.shapesize(5, 1)
paddle_a.penup()
paddle_a.goto(-350, 0)

# Paddle B
paddle_b = turtle.Turtle()
paddle_b.speed(0)
paddle_b.shape("square")
paddle_b.color("white")
paddle_b.shapesize(5, 1)
paddle_b.penup()
paddle_b.goto(350, 0)

# Ball
ball = turtle.Turtle()
ball.speed(0)
ball.shape("circle")
ball.color("red")
ball.penup()
ball.goto(0, 0)
ball.dx = 0.1
ball.dy = -0.1

# Pen module
pen = turtle.Turtle()
pen.speed(0)
pen.color("white")
pen.penup()
pen.hideturtle()
pen.goto(0, 260)
pen.clear()
pen.write("Player A: 0                          Player B: 0", align="center", font=("Courier", 14, "normal"))


# Functions
def paddle_a_up():
    y = paddle_a.ycor()
    y += 20
    paddle_a.sety(y)
    if paddle_a.ycor() > 320:
        paddle_a.sety(-320)


def paddle_a_down():
    y = paddle_a.ycor()
    y -= 20
    paddle_a.sety(y)
    if paddle_a.ycor() < -320:
        paddle_a.sety(320)


def paddle_b_up():
    y = paddle_b.ycor()
    y += 20
    paddle_b.sety(y)
    if paddle_b.ycor() > 320:
        paddle_b.sety(-320)


def paddle_b_down():
    y = paddle_b.ycor()
    y -= 20
    paddle_b.sety(y)
    if paddle_b.ycor() < -320:
        paddle_b.sety(320)


# Keyboard binding
window_panel.listen()
window_panel.onkeypress(paddle_a_up, "w")
window_panel.onkeypress(paddle_a_down, "s")
window_panel.onkeypress(paddle_b_up, "Up")
window_panel.onkeypress(paddle_b_down, "Down")

# Main Game
start_time = int(time.perf_counter())
while True:
    window_panel.update()

    # Speed increase
    elapsed_time = int(time.perf_counter() - start_time)
    # print(elapsed_time)
    if elapsed_time / 10 == 1:
        if ball.dx > 0:
            ball.dx += 0.02
        else:
            ball.dx -= 0.02
        if ball.dy < 0:
            ball.dy -= .02
        else:
            ball.dy += 0.02
        start_time = int(time.perf_counter())

    # Move the ball
    ball.setx(ball.xcor() + ball.dx)
    ball.sety(ball.ycor() + ball.dy)

    # Border Checking
    # # Upper
    if ball.ycor() > 290:
        ball.sety(290)
        ball.dy *= -1
    # # Lower
    if ball.ycor() < -290:
        ball.sety(-290)
        ball.dy *= -1

    # # Right
    if ball.xcor() < -390:
        ball.goto(0, 0)
        ball.dx *= -1
        score_b += 1
        pen.clear()
        pen.write("Player A: {}                          Player B: {}".format(score_a, score_b), align="center",
                  font=("Courier", 14, "normal"))
        # # Left
    if ball.xcor() > 390:
        ball.goto(0, 0)
        ball.dx *= -1
        score_a += 1
        pen.clear()
        pen.write("Player A: {}                          Player B: {}".format(score_a, score_b), align="center",
                  font=("Courier", 14, "normal"))

    # Paddle ball collision
    if 340 < ball.xcor() < 350 and (paddle_b.ycor() + 40 > ball.ycor() > paddle_b.ycor() - 40):
        ball.setx(340)
        ball.dx *= -1

    if -340 > ball.xcor() > -350 and (paddle_a.ycor() + 40 > ball.ycor() > paddle_a.ycor() - 40):
        ball.setx(-340)
        ball.dx *= -1
