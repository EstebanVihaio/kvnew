package com.adruijter.kingsvalley1.explorer;

import com.adruijter.kingsvalley1.animatedsprite.AnimatedSprite;

public class ExplorerIdleRight extends AnimatedSprite{
	//Fields
    private Explorer explorer;

    //Constructor
    public ExplorerIdleRight(Explorer explorer)
    {
    	super(explorer);
    	this.explorer = explorer;
        this.i = 7;
    }

    public void Update(float delta)
    {
        /*
    	if (Input. DetectKeyDown(Keys.Right))
        {
            this.explorer.State = this.explorer.WalkRight;
        }
        if (Input.DetectKeyDown(Keys.Left))
        {
            this.explorer.State = this.explorer.WalkLeft;
        }
        if (Input.EdgeDetectKeyDown(Keys.Space))
        {
            this.explorer.State = this.explorer.IdleJumpRight;
            this.explorer.IdleJumpRight.Initialize();
        }
        */
        //base.Update(gameTime);
    }
    
    public void Draw(float delta)
    {
        super.Draw(delta);
    }
}
