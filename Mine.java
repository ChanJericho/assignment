import java.util.ArrayList;



    public class Mine {
        private char[][] area;
        private int size = 1;
        private int posX = 0;
        private int posY = 0;
        private char front = '>';
        private int moves = 0;
        private int scans = 0;
        private int rotates = 0;
        public ArrayList<Integer> goldX = new ArrayList<>();
        public ArrayList<Integer> goldY = new ArrayList<>();
        public ArrayList<Integer> memoryX = new ArrayList<>();
        public ArrayList<Integer> memoryY = new ArrayList<>();
        public ArrayList<Integer> visitedX = new ArrayList<>();
        public ArrayList<Integer> visitedY = new ArrayList<>();

        public Mine(int n) {

            size = n;
            area = new char[n][n];

            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                {
                    area[i][j] = ' ';
                }
            addMemory(0,0);
        }

        public int getSize(){
            return size;
        }

        public void showArea() {

            for(int k = 0; k < size; k++)
                System.out.print("------");

            System.out.print("-\n");

            for(int i = 0; i < size;i++){

                System.out.print("|  ");
                for(int j = 0; j < size; j++) {
                    if(i == posX && j == posY){
                        System.out.print(front + "  |  ");
                    }
                    else{
                        System.out.print(area[i][j] + "  |  ");
                    }
                }
                System.out.print("\n");
                for(int k = 0; k < size; k++)
                    System.out.print("|-----");
                System.out.print("|\n");
            }
            System.out.println("Moves: " + moves + "\tRotates: " + rotates + "\tScans: " + scans);
            System.out.println("\n\n");

            delay();
        }

        public char[][] getArea() {
            return area;
        }

        public char scan() {
            int x = this.posX, y = this.posY;
            int i;
            scans++;
            showArea();
            if(front == '>'){
                i = y + 1;
                if(i < size)
                    if(area[x][i] == 'P')
                        return 'P';
                    else if(area[x][i] == 'B')
                        return 'B';
                    else if(area[x][i] == 'G')
                        return 'G';
            }
            else if(front == 'v'){
                i = x + 1;
                if(i < size)
                    if(area[i][y] == 'P')
                        return 'P';
                    else if(area[i][y] == 'B')
                        return 'B';
                    else if(area[i][y] == 'G')
                        return 'G';
            }
            else if(front == '<'){
                i = y - 1;
                if(i >= 0)
                    if(area[x][i] == 'P')
                        return 'P';
                    else if(area[x][i] == 'B')
                        return 'B';
                    else if(area[x][i] == 'G')
                        return 'G';
            }
            else if(front == '^'){
                i = x - 1;
                if(i >= 0)
                    if(area[i][y] == 'P')
                        return 'P';
                    else if(area[i][y] == 'B')
                        return 'B';
                    else if(area[i][y] == 'G')
                        return 'G';
            }

            return '0';
        }

        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public int getFront() {
            return front;
        }

        public void rotate() {
            if(front == '>')
                front = 'v';
            else if (front == 'v')
                front = '<';
            else if (front == '<')
                front = '^';
            else if (front == '^')
                front = '>';

            rotates++;
            showArea();
        }

        public char move(){
            if(front == '>'){
                if(posY != size - 1){
                    posY++;
                    moves++;
                    showArea();
                }

            }
            else if(front == 'v'){
                if(posX != size - 1){
                    posX++;
                    moves++;
                    showArea();
                }

            }
            else if(front == '<'){
                if(posY != 0){
                    posY--;
                    moves++;
                    showArea();
                }

            }
            else if(front == '^'){
                if(posX != 0){
                    posX--;
                    moves++;
                    showArea();
                }

            }

            if(area[posX][posY] == 'G')
            {
                System.out.println("CONGRATS!! SEARCH SUCCESSFUL");
            }
            else if(area[posX][posY] == 'P')
            {
                System.out.println("OH NO?!? YOU DIED!!!");
            }

            return area[posX][posY];
        }

        public void addBlock(int x, int posX, int posY){
            char letter = ' ';

            if(x == 1){
                letter = 'G';
                goldX.add(posX);
                goldY.add(posY);
            }
            else if(x == 2){
                letter = 'B';
            }
            else if(x == 3){
                letter = 'P';
            }


            area[posX][posY] = letter;
        }

        public void delay(){
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        public void addMemory(int x, int y){
            this.memoryX.add(x);
            this.memoryY.add(y);
            this.visitedX.add(x);
            this.visitedY.add(y);
        }

        public boolean checkMemory(int x, int y){
            if(getFront() == '<')
                y-=1;
            else if(getFront() == '>')
                y+=1;
            else if(getFront() == '^')
                x-=1;
            else if(getFront() == 'v')
                x+=1;

            for(int i = 0; i < visitedX.size(); i++)
                if(x == visitedX.get(i) && y == visitedY.get(i)) {
                    return true;
                }

            return false;
        }
    }
