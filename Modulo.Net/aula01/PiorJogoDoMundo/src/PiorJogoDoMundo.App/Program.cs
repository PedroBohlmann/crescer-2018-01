using System;

namespace PiorJogoDoMundo.App
{
    class Program
    {

        public static void PrintMatrix(char [,]matrix){
            Console.SetCursorPosition(0, 0);
            for(int i=0;i<matrix.GetLength(0);i++){
                for(int j=0;j<matrix.GetLength(1);j++){
                    Console.Write(matrix[i,j]);
                }
                Console.WriteLine(' ');
            }
        }

        public static Boolean CheckPostionIsValid(char [,]matrix,int x,int y){
            return (matrix[x,y]!='X');
        }

        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            var matrix=new char[10,20];

            for(int i=0;i<matrix.GetLength(0);i++){
                for(int j=0;j<matrix.GetLength(1);j++){
                    if((i==0)||(i==matrix.GetLength(0)-1)||((j==0)||(j==matrix.GetLength(1)-1))){
                        matrix.SetValue('X',i,j);
                    }else{
                        matrix.SetValue(' ',i,j);
                    }
                }
            }

            var x=1;
            var y=1;

            matrix.SetValue('O',x,y);

            ConsoleKey key;

            Console.Clear();
            do{
                PrintMatrix(matrix);

                key=Console.ReadKey(true).Key;
                switch(key){
                    case ConsoleKey.UpArrow:
                        if(CheckPostionIsValid(matrix,x-1,y)){
                            matrix.SetValue(' ',x--,y);
                            matrix.SetValue('O',x,y);
                        }
                        break;
                    case ConsoleKey.DownArrow:
                        if(CheckPostionIsValid(matrix,x+1,y)){
                            matrix.SetValue(' ',x++,y);
                            matrix.SetValue('O',x,y);
                        }
                        break;
                    case ConsoleKey.RightArrow:
                        if(CheckPostionIsValid(matrix,x,y+1)){
                            matrix.SetValue(' ',x,y++);
                            matrix.SetValue('O',x,y);
                        }
                        break;
                    case ConsoleKey.LeftArrow:
                        if(CheckPostionIsValid(matrix,x,y-1)){
                            matrix.SetValue(' ',x,y--);
                            matrix.SetValue('O',x,y);
                        }
                        break;
                    
                }

            }while(key!=ConsoleKey.Spacebar);
        }
    }
}
