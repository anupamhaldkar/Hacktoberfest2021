import pygame

# initialise the pygame
pygame.init()

# create the window
screen = pygame.display.set_mode((800, 600))  # pygame.FULLSCREEN)

# Title and icon
pygame.display.set_caption("Pygame")
icon = pygame.image.load('spaceship.png')
pygame.display.set_icon(icon)
screen.fill((0, 155, 0))

#Player


running = True
while running:

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

pygame.display.update()
