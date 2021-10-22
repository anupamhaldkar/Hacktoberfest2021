import turtle
import time

win_pane = turtle.Screen()
win_pane.title("PONG by Rishav")
win_pane.bgcolor("black")
win_pane.setup(width=800, height=600)
win_pane.tracer(0)


def HvsH():
    win_pen.clear()
    win_pen.write("Playing Human vs Human", align="center", font=("Courier", 24, "normal"))
    time.sleep(1)
    win_pen.clear()
    win_pen.write("Get Ready!!!!!", align="center", font=("Courier", 24, "normal"))
    time.sleep(1)
    win_pen.clear()
    import pongHvsH


def HvsM():
    win_pen.clear()
    win_pen.write("Playing Human vs Machine", align="center", font=("Courier", 24, "normal"))
    time.sleep(1)
    win_pen.clear()
    win_pen.write("Get Ready!!!!!", font=("Courier", 24, "normal"), align="center")
    time.sleep(1)
    win_pen.clear()
    import pongHvsM


# win_pen module
win_pen = turtle.Turtle()
win_pen.speed(0)
win_pen.color("white")
win_pen.penup()
win_pen.hideturtle()
win_pen.goto(0, 0)
win_pen.write("PRESS H: To play Human vs Human\nPRESS M: To play Human vs Machine", align="center",
              font=("Courier", 24, "normal"))
win_pane.listen()
win_pane.onkeypress(HvsH, "h")
win_pane.onkeypress(HvsM, "m")

while True:
    win_pane.update()
