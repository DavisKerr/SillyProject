package ctec.sillyproject;

import java.util.ArrayList;
import java.util.Random;

import ctec.sillyproject.R;
import ctec.sillyproject.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Opens an activity that changes the color randomly based on the button click.
 * @author dker2024
 *@version 1.0 10/14/14
 */
public class MainActivity extends Activity
{
	private Button appButton;
	private TextView appText;
	private RelativeLayout appLayout;
	private int counter;
	private ArrayList<Integer> colorList;
	private Button changeActivityButton;
	private MagicActivity magicApp;

	/**
	 * creates the activity and sets up the lists and listeners.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		colorList = new ArrayList<Integer>(); //STOP FORGRETTING THIS!!!
		
		//Gives you access to a button or any view object
		appButton = (Button) findViewById(R.id.colorButton);
		changeActivityButton = (Button) findViewById(R.id.ChangeButton);
		appText = (TextView) findViewById(R.id.sillyText);
		appLayout = (RelativeLayout) findViewById(R.id.Layout);
		counter = 0;
		magicApp = new MagicActivity();
		
		setUpColorList();
		setupListeners();
		
	}
	
	/**
	 * Fills the color list.
	 */
	private void setUpColorList()
	{
		
		colorList.add(R.color.Blue);
		colorList.add(R.color.uglyGreen);
		colorList.add(R.color.Red);
		colorList.add(R.color.randomColor);
		
	}
	
	/**
	 * detects when a button is clicked.
	 */
	private void setupListeners()
	{
		
		changeActivityButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//startActivity(MagicActivity.class);
			}
		});
		
		appButton.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				counter = chooseRandomFromList(colorList);
				appLayout.setBackgroundResource(counter);
				
			}
		});	
		
	}
	
	/**
	 * picks a random item from a list.
	 * @param sourceList the list to pick from.
	 * @return chosenColor returns the result of the list.
	 */
	private int chooseRandomFromList(ArrayList<Integer> sourceList)
	{
		int chosenColor;
		int indexID;
		
		indexID = (int)(Math.random() * (sourceList.size())); 
		chosenColor = sourceList.get(indexID);
		return chosenColor;
	}
	

}
