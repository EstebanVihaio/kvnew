package com.adruijter.kingsvalley1.stairsRight;

import com.adruijter.kingsvalley1.KingsValley1;
import com.adruijter.kingsvalley1.brick.IBuildingBlock;
import com.adruijter.kingsvalley1.brick.Image;
import com.badlogic.gdx.math.Vector2;

public class StepRight extends Image implements IBuildingBlock {

	//Fields
	private char character;
    private String imageName;
    
	//Constructor
	public StepRight(KingsValley1 game, Vector2 position, String imageName, char character) {
		super(game, position, "data/Stairs/" + imageName);
		this.character = character;
		this.imageName = imageName;
	}
	
	//Properties
	
	@Override
	public void Draw(float delta) {		
		super.Draw(delta);
	}

	@Override
	public char getCharacter() {
		return this.character;
	}

	@Override
	public String getImageName() {
		return this.imageName;
	}

	@Override
	public void setImageName(String imageName) {
		// TODO Auto-generated method stub
		
	}

}
