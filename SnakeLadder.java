public class SnakeLadder {

	//Constants
	public static final int NO_PLAY = 0;
	public static final int LADDER = 1;
	public static final int SNAKE = 2;
	public static final int WIN_POS = 100;

        public void gameSim() {

                //Game Simulation
                int currPos = 0;
                while(currPos <= WIN_POS) {
                        int diceRoll = diceRoll();
                        //Option Check
                        currPos = optionSelect(currPos, diceRoll);

                        if(currPos<0) //If current position goes below 0, reset
                                currPos = 0;

                        System.out.println("The current Position of the player is: " + currPos);
                }

        }


	public int diceRoll() {

	        //Dice Roll
		int dice = 1 + (int)( (Math.random() * 10) % 6);
		System.out.println("The Dice Rolled: " + dice);
		return dice;

	}

	public int optionSelect(int currPos, int diceRoll) {
		//Option Selection No Play/Snake/Ladder
		int option = (int)( (Math.random() * 10) % 3 );
		switch(option) {
			case NO_PLAY:
				System.out.println("The option was to no play, hence the player will not advance");
                                break;
                        case LADDER:
                                System.out.println("The option came to Ladder, the player move forward: " + diceRoll + " steps");
                                currPos += diceRoll;
                                return currPos;
				//break;
			case SNAKE:
                                System.out.println("The option came to Snake, the player will backward: " + diceRoll + " steps");
                                currPos -= diceRoll;
                                return currPos;
			        //break;
                        default:
                                System.out.println("Some error occured, default case");
                                break;

                        }
		return currPos;
	}

	public static void main(String[] args) {

		SnakeLadder obj = new SnakeLadder();
		obj.gameSim();
	}
}
