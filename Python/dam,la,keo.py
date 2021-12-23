from random import randint

print("Dam, La, Keo")
player = input()
computer = randint(1, 3)
if computer == 1:
    computer = "Dam"
if computer == 2:
    computer = "La" 
if computer == 3:
    computer = "Keo"

print("You choose: " + player)
print("Computer chooses: " + computer)

if player == computer:
    print("Draw")
else:
    if player == "Dam":
        if computer == "Keo":
            print("You Win")
        else:
            print("You Lose")
    elif player == "La":
        if computer == "Dam":
            print("You Win")
        else:
            print("You Lose")
    elif player == "Keo":
        if computer == "La":
            print("You Win")
        else:
            print("You Lose")
    else:
        print("ERROR! Retype")
        

