package com.adruijter.kingsvalley1.level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.adruijter.kingsvalley1.KingsValley1;
import com.adruijter.kingsvalley1.brick.Brick;
import com.adruijter.kingsvalley1.brick.IBuildingBlock;
import com.adruijter.kingsvalley1.explorer.Explorer;
import com.adruijter.kingsvalley1.floor.Floor;
import com.adruijter.kingsvalley1.stairsLeft.StairsLeft;
import com.adruijter.kingsvalley1.stairsLeft.StepLeft;
import com.adruijter.kingsvalley1.stairsRight.StairsRight;
import com.adruijter.kingsvalley1.stairsRight.StepRight;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;

public class Level {

	//Fields
	private KingsValley1 game;
    private String levelPath;
    private ArrayList<String> lines;
    private int width, height;
    private IBuildingBlock bricks[][];
    private Explorer explorer;
    private ArrayList<StairsRight> stairsRight;
    private ArrayList<StairsLeft> stairsLeft;
    private ArrayList<Floor> floors; 
	
	public Level(KingsValley1 game, int levelIndex) throws IOException 
	{
		this.game = game;
		this.levelPath = String.format("data/%s.txt", levelIndex);
        this.LoadAssets();
        this.stairsRight = new ArrayList<StairsRight>();
        this.stairsLeft = new ArrayList<StairsLeft>();
        this.floors = new ArrayList<Floor>();
        this.DetectStairsRight();
        this.DetectStairsLeft();
        /*
        this.DetectFloors();
        ExplorerManager.StairsRight = this.stairsRight;
        ExplorerManager.StairsLeft = this.stairsLeft;
        */
	}

	private void LoadAssets() throws IOException {
		this.lines = new ArrayList<String>();
		FileHandle handle = Gdx.files.internal(this.levelPath);
		 BufferedReader reader = new BufferedReader(new InputStreamReader(handle.read()));
	     String line = reader.readLine();
        //StreamReader reader = new StreamReader(this.levelPath);
        //string line = reader.ReadLine();
        this.width = line.length();
        while (line != null)
        {
            lines.add(line);
            line = reader.readLine();
        }
        this.height = lines.size();
        this.bricks = new IBuildingBlock[this.width][ this.height];

        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                char brickElement = lines.get(i).charAt(j);
                this.bricks[j][i] = this.LoadObject(brickElement, j * 16, i * 16);
            }
        }
	}
	
	private IBuildingBlock LoadObject(char brickElement, int x, int y)
	{
		switch (brickElement)
        {
            case '.':
                return new Brick(this.game, new Vector2(x, y), "Brick_transparant.png", '.');
            case '1':
                return new Brick(this.game, new Vector2(x, y), "Brick.png", '1');
            case '2':
                return new Brick(this.game, new Vector2(x, y), "fundament.png", '2');
            case '3':
                return new Brick(this.game, new Vector2(x, y), "EmptySpace.png", '3');
            case '+':
            	this.explorer = new Explorer(this.game, new Vector2(x, y));                 
            	return new Brick(this.game, new Vector2(x, y), "Brick_transparant.png", '+');
            case 's':
                return new StepRight(this.game, new Vector2(x, y), "trapTopRight01.png", 's');
            case 'x':
                return new StepLeft(this.game, new Vector2(x, y), "trapTopLeft01.png", 'x');
            default:
                return new Brick(this.game, new Vector2(x, y), "Brick_transparant.png", '.');
        }
	}
	
	 public void DetectStairsRight()
     {
         for (int i = 0; i < this.height; i++)
         {
             for (int j = 0; j < this.width; j++)
             {
                 if (this.bricks[j][i].getImageName() == "trapTopRight01.png")
                 {
                     int amountOfStairs = 0;
                     int horizontal = j + 1;
                     for (int k = (i + 1); k < this.height; k++)
                     {
                         horizontal--;
                         if (this.bricks[horizontal][k].getImageName() == "Brick.png")
                         {
                             amountOfStairs = k - i - 1;
                             break;
                         }
                     }
                     this.stairsRight.add(new StairsRight(this.game, new Vector2(j * 16, i * 16), amountOfStairs));
                 }
             }
         }
     }
	 
	 private void DetectStairsLeft()
     {
         for (int i = 0; i < this.height; i++)
         {
             for (int j = 0; j < this.width; j++)
             {
                 if (this.bricks[j][i].getImageName() == "trapTopLeft01.png")
                 {
                     int amountOfStairs = 0;
                     int horizontal = j;
                     for (int k = (i + 1); k < this.height; k++)
                     {
                         horizontal++;
                         if (this.bricks[horizontal][k].getImageName() == "Brick.png")
                         {
                             amountOfStairs = k - i - 1;
                             break;
                         }
                     }
                     this.stairsLeft.add(new StairsLeft(this.game, new Vector2(j * 16f, i * 16f), amountOfStairs));
                 }
             }
         }
     }
	
	public void Update(float delta)
    {
		if (this.explorer != null)
		this.explorer.Update(delta);
    }

    public void Draw(float delta)
    {
        for (int i = 0; i < this.bricks.length; i++)
        {
            for (int j = 0; j < this.bricks[i].length; j++)
            {
               this.bricks[i][j].Draw(delta);
            }
        }
        
        for (StairsRight stair : this.stairsRight)
        {
            stair.Draw(delta);
        }
        
        for (StairsLeft stair : this.stairsLeft)
        {
            stair.Draw(delta);
        }
       
        if (this.explorer != null)
            this.explorer.Draw(delta);
    }
}
