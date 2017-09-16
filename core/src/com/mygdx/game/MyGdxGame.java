package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	final int NUM = 10;
	Texture[] img = new Texture[NUM];
	//float t1 = 1.0f;
	//float t2 = 0.1f;

	int[] H = new int[NUM];
	int[] HH = new int[NUM];
	int[] W = new int[NUM];
	int[] HW = new int[NUM];

	int HI;
	int WI;

	float[] x = new float[NUM];
	float[] y = new float[NUM];
	float[] vx = new float[NUM];
	float[] vy = new float[NUM];
	float[] t = new float[NUM];

	float dt;

	@Override
	public void create () {
		HI = Gdx.graphics.getHeight();
		WI = Gdx.graphics.getWidth();

		batch = new SpriteBatch();
		for (int i = 0; i < img.length; i++) {
			img[i] = new Texture("asteroid.png");

			H[i] = img[i].getHeight();
			HH[i] = H[i] / 2;
			W[i] = img[i].getWidth();
			HW[i] = W[i] / 2;

			x[i] = (float) (Math.random()*WI/3)+WI/6;
			y[i] = (float) (Math.random()*HI/3)+HI/6;
			vx[i] = (float) (Math.random()*WI/3)-WI/6;
			vy[i] = (float) (Math.random()*HI/3)-HI/6;
			t[i] = (float)(Math.random()*360);
		}

	}

	@Override
	public void render () {
		dt = Gdx.graphics.getDeltaTime();
		update(dt);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i < img.length; i++) {
			batch.draw(img[i], x[i], y[i], HW[i], HH[i], W[i], H[i],0.3f,0.3f,t[i],0,0, W[i], H[i],false,false);
		}
		batch.end();
	}

	public void update(float time){
		//t2*=1.015f;

//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ x+=vx*time;}
//		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){ x-=vx*time;}
//		if(Gdx.input.isKeyPressed(Input.Keys.UP)){ y+=vy*time;}
//		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){ y-=vy*time;}
		for (int i = 0; i < img.length; i++) {
			x[i]+=vx[i]*time;
			y[i]+=vy[i]*time;
			t[i]+=1;
		}


//		if(Gdx.input.isTouched()){
//			if(Gdx.input.getX() < x + HW){ x-=vx*time;}
//			if(Gdx.input.getX() > x + HW){ x+=vx*time;}
//			if(HI - Gdx.input.getY() < y + HH){ y-=vy*time;}
//			if(HI - Gdx.input.getY() > y + HH){ y+=vy*time;}
//		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (int i = 0; i < 4; i++) {
			img[i].dispose();
		}
	}
}
