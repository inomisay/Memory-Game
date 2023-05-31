# Memory-Game
<img width="159" alt="Screen Shot 2023-05-31 at 16 18 13" src="https://github.com/inomisay/Memory-Game/assets/98346164/448b2a91-2a41-4743-99e4-ea9db2a334dd">

Write a program in the Java programming language for the matching pairs card game: **“Memory Game”**.
It is a game that requires finding identical pairs.
In other words, it is a game where the user needs to match pairs of tiles.
Tiles should include *animal* words such as dog, cat, bird, rabbit, etc.

# The Beginning of the Game

There is a text file (D:\\animals.txt). The number of animals is unknown. Read the file and insert them in an **AnimalSLL**.
A sample file: animals.txt
<img width="110" alt="Screen Shot 2023-05-31 at 16 19 23" src="https://github.com/inomisay/Memory-Game/assets/98346164/1a7d5c21-8b6c-43f7-97b4-2430aaf0b62c">
A sample **single linked-list (SLL)** that includes animals:
<img width="904" alt="Screen Shot 2023-05-31 at 16 19 50" src="https://github.com/inomisay/Memory-Game/assets/98346164/4869eed8-b5d5-4719-814f-2f0e9ebb7a7a">

There are two single linked-lists (**SLL1** and **SLL2**) with n in size. The second SLL contains the matches of tiles in the first SLL.
At the beginning of the game, take the value of n from the user.
The game boards (**SLL1** and **SLL2**) must be randomly filled with *distinct* pairs. You should randomly select n animals from animalSLL to
fill game boards. Each element in a SLL should be different from the others. For example, a SLL doesn’t contain two dogs.

<img width="436" alt="Screen Shot 2023-05-31 at 16 20 47" src="https://github.com/inomisay/Memory-Game/assets/98346164/77c0655d-d29b-4439-8a61-f16d20419cdc">

# Game Playing
Playing is very simple - the computer turns over two tiles randomly, one tile from the first SLL and one tile from the second SLL. If they are identical, the program deletes them from the game boards (**SLLs**), if not, it tries again.

# The End of the Game
When all pairs are identified (when all tiles are deleted from the game boards (**SLLs**), the game will be over. The program must display all steps until the game is over.
The followings should be printed at each iteration. - the number of tries (step) and
- the score.
The program ends after printing the high score table on the screen.

# Scoring
The scoring principle is as follows:
- Each time the computer makes a successful match, the score should be increased by 20 points. 
- If the computer fails to match, the score should be decreased by 1 point.

# High Score Table
Read an unsorted file “D:\\highscoretable.txt” and then create two **SLLs (SLL3 and SLL4)**, which are sorted by score as follows:

<img width="113" alt="Screen Shot 2023-05-31 at 16 22 02" src="https://github.com/inomisay/Memory-Game/assets/98346164/c1c18cff-6162-46f0-b577-b0bd639be8ab">

<img width="664" alt="Screen Shot 2023-05-31 at 16 22 12" src="https://github.com/inomisay/Memory-Game/assets/98346164/b46ccfda-21d2-4878-931d-2b5f0e707b75">

*Notes:*
1- The number of elements in the high score table is unknown, but it must contain maximum 12 items. 
2- If more than one player has the same score, the older one must be added first.
If he/she gets a score within the top-12 results, he/she must be inserted into the high-score SLLs (SLL3 and SLL4). If the same score exists in the table, the new score should be inserted to the next of them.
At the end of the game, the new score table should be written to the same file.

<img width="661" alt="Screen Shot 2023-05-31 at 16 22 49" src="https://github.com/inomisay/Memory-Game/assets/98346164/a4c0bb48-8d8c-4965-bee4-833fbdf3191f">

<img width="101" alt="Screen Shot 2023-05-31 at 16 22 57" src="https://github.com/inomisay/Memory-Game/assets/98346164/e7cfe68a-2b55-4496-a37e-64e43ca8cacb">


# Notes
1- In your program, you can use **Single Linked List (SLL)** as you want, but you must use *only* **SLL**, don’t use other data structures.
**Don’t** use *array* or *array list* or *list* data structures embedded in Java.
**Don’t** use *stack* or *queue*.
**Don’t** use a *string* as the primary data structure in the main solution, instead of SLL.
2- Don’t use **ENIGMA** or any other extra library.
3- Your program must work correctly under all conditions. Try to control all possible errors.
4- You should use meaningful variable names, appropriate comments, and good prompting messages.



