import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        int choice = 0;
        int gameOver = 0;
        char block = '*';
        Random rand = new Random();
        Scanner kb = new Scanner(System.in);


        System.out.print("Enter the size of the mine: ");
        int num = Integer.parseInt(kb.nextLine());
        Mine mine = new Mine(num);

        while(choice != 4) {

            System.out.print("[1] Add Gold\n[2] Add Beacon\n[3] Add Pit\n[4] Start\nChoice: ");
            choice = Integer.parseInt(kb.nextLine());

            if(choice != 4){
                System.out.print("Enter x coordinate: ");
                int a = Integer.parseInt(kb.nextLine());
                System.out.print("Enter y coordinate: ");
                int b = Integer.parseInt(kb.nextLine());

                mine.addBlock(choice,a,b);
            }
        }

        choice = 0;

        while(choice != 1 && choice != 2) {

            System.out.print("[1] Random Agent\n[2] Smart Agent\nChoice: ");
            choice = Integer.parseInt(kb.nextLine());
        }
        kb.close();
        mine.showArea();
        //Random
        if(choice == 1) {
            while (gameOver == 0) {
                int x = rand.nextInt(3);

                if (x == 1) {
                    block = mine.move();
                } else if (x == 2) {
                    mine.rotate();
                } else {
                    mine.scan();
                }
                if (block == 'P' || block == 'G')
                    gameOver = 1;
            }
        }

        else{
            int key = 1;
            while(key == 1){
                if(search(mine) == 1)
                    key = 0;
            }

        }
    }

    public static int search(Mine mine){
        //checks in front and around for gold
        int x = scanAround(mine);

        if(x == 1) //gold is found
            return 1;

            //obstacle is in front
        else if(x == -1){
            mine.rotate();
            if(isScanValid(mine) == 0){
                mine.rotate();
                mine.rotate();
                if(isScanValid(mine) == 0){
                    stepBack(mine);
                    return 0;
                }
                else if(scanCheck(mine) == 1 || mine.scan() == 'P'){
                    stepBack(mine);
                    return 0;
                }
            }
            else if(scanCheck(mine) == 1 || mine.scan() == 'P'){
                mine.rotate();
                mine.rotate();
                if(isScanValid(mine) == 0){
                    stepBack(mine);
                    return 0;
                }
                else if(scanCheck(mine) == 1 || mine.scan() == 'P'){
                    stepBack(mine);
                    return 0;
                }
            }
        }

        mine.move();
        mine.addMemory(mine.getPosX(), mine.getPosY());

        return 0;
    }

    //check surroundings for gold or beacons
    public static int scanAround(Mine mine){
        char block = ' ';
        for(int i = 0; i < 3; i++){
            if(i == 1)
                mine.rotate();

            mine.rotate();

            if (mine.getPosX() != 0 || mine.getFront() != '^')
                if (mine.getPosX() != mine.getSize() - 1 || mine.getFront() != 'v')
                    if (mine.getPosY() != 0 || mine.getFront() != '<')
                        if (mine.getPosY() != mine.getSize() - 1 || mine.getFront() != '>')
                            if(scanCheck(mine) == 0)
                                block = mine.scan();

            if (block == 'G'){
                mine.move();
                return 1;
            }
            else if(block == 'B') {
                mine.move();
                mine.addMemory(mine.getPosX(), mine.getPosY());
                int j = beacon(mine);
                if (j != 0) {
                    if (goldHunt(mine, j) == 1)
                        return 1;
                }
            }
        }

        if(block == 'P')
            return -1;
        else if (mine.getPosX() != 0 || mine.getFront() != '^')
            if (mine.getPosX() != mine.getSize() - 1 || mine.getFront() != 'v')
                if (mine.getPosY() != 0 || mine.getFront() != '<')
                    if (mine.getPosY() != mine.getSize() - 1 || mine.getFront() != '>')
                        if(scanCheck(mine) == 0)
                            return 0;

        return -1;
    }

    public static int beacon(Mine mine){
        int num = 65;
        int x = mine.getPosX();
        int y = mine.getPosY();
        for(int i = 0; i < mine.goldX.size(); i++){
            if(mine.goldX.get(i) == x) {
                if(mine.goldY.get(i) > y){
                    if((mine.goldY.get(i) - y) < num)
                        num = mine.goldY.get(i) - y;
                }
                else if(mine.goldY.get(i) < y){
                    if((y - mine.goldY.get(i)) < num)
                        num = y - mine.goldY.get(i);
                }
            }
        }

        for(int i = 0; i < mine.goldY.size(); i++){
            if(mine.goldY.get(i) == y) {
                if(mine.goldX.get(i) > x){
                    if((mine.goldX.get(i) - x) < num)
                        num = mine.goldX.get(i) - x;
                }
                else if(mine.goldX.get(i) < x){
                    if((x - mine.goldX.get(i)) < num)
                        num = x - mine.goldX.get(i);
                }
            }
        }

        if(num == 65)
            return 0;

        return num;
    }

    public static int goldHunt(Mine mine, int j) {
        int moves;
        for (int k = 0; k < 4; k++) {
            moves = 0;
            char block;
            for (int i = 0; i < j; i++) {
                block = 'P';
                if (mine.getPosX() != 0 || mine.getFront() != '^')
                    if (mine.getPosX() != mine.getSize() - 1 || mine.getFront() != 'v')
                        if (mine.getPosY() != 0 || mine.getFront() != '<')
                            if (mine.getPosY() != mine.getSize() - 1 || mine.getFront() != '>')
                                if(scanCheck(mine) == 0)
                                    block = mine.scan();

                if (block != 'P') {
                    moves++;
                    if (mine.move() == 'G')
                        return 1;
                } else
                    i = j;
            }
            mine.rotate();
            mine.rotate();

            for (int i = 0; i < moves; i++) {
                mine.move();
            }

            mine.rotate();
        }
        return 0;
    }

    public static int scanCheck(Mine mine){
        if(mine.checkMemory(mine.getPosX(), mine.getPosY()))
            return 1;
        else
            return 0;
    }

    public static int isScanValid(Mine mine){
        if (mine.getPosX() != 0 || mine.getFront() != '^')
            if (mine.getPosX() != mine.getSize() - 1 || mine.getFront() != 'v')
                if (mine.getPosY() != 0 || mine.getFront() != '<')
                    if (mine.getPosY() != mine.getSize() - 1 || mine.getFront() != '>')
                        return 1;

        return 0;
    }

    public static void stepBack(Mine mine){
        int x = mine.memoryX.size() - 2;
        int y = mine.memoryY.size() - 2;
        if(mine.getPosX() - mine.memoryX.get(x) < 0){
            while(mine.getFront() != 'v')
                mine.rotate();
        }
        else if(mine.getPosX() - mine.memoryX.get(x) > 0){
            while(mine.getFront() != '^')
                mine.rotate();
        }
        else if(mine.getPosY() - mine.memoryY.get(y) < 0){
            while(mine.getFront() != '>')
                mine.rotate();
        }
        else if(mine.getPosY() - mine.memoryY.get(y) > 0){
            while(mine.getFront() != '<')
                mine.rotate();
        }

        mine.memoryX.remove(x + 1);
        mine.memoryY.remove(y + 1);
        mine.move();
    }
}

