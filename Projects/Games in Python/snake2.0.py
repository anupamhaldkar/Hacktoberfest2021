import pygame

class Cube(object):
    rows = 0
    w = 0

    def __init__(self, start, dirnx=1, dirny=0, color=(255, 0, 0)):
        pass

    def move(self, dirnx, dirny):
        pass

    def draw(self, surface, eyes=False):
        pass


class Snake(object):
    def __index__(self, color, pos):
        pass

    def move(self):
        pass

    def reset(self, pos):
        pass

    def add_cube(self):
        pass

    def draw(self, surface):
        pass


def draw_grid(w, rows, surface):
    pass


def re_draw_window(surface):
    pass


def random_snack(rows, items):
    pass


def message_box(subject, content):
    pass


def main():
    width = 500
    height = 500
    rows = 20
    win = pygame.display.set_mode((width, height))
    s = snake()
