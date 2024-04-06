package application;
	
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application 
{
	
	//main
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
	Board board;
	Label x;
	Label o;
	
	int mode;
	
	
	boolean check;
	
	
	String player1e;
	String comp;
	
	String player1h;
	String comph; 
	
	String player1Name;
    String player2Name;
    
	Font fontOfLabel = new Font("Maiandra GD",23);
	Font fontmessage = new Font("Copperplate Gothic Bold", 23);
	
	//All Panes of modes
	Pane easyPane = new Pane();
	Pane multiplePane = new Pane();
	Pane impossiblePane = new Pane();
	
	Label resultGameEasy = new Label("");
	Label resultGamelbl2 = new Label("");
	Label resultGamelbl3 = new Label("");



	@Override
	public void start(Stage startStage)
	{
 
		resultGameEasy.setFont(fontmessage);
		resultGamelbl2.setFont(fontmessage);
		resultGamelbl3.setFont(fontmessage);
		
		//________________________Start stage____________________________________________________________
		
		Pane startPane = new Pane();
		Scene startScene = new Scene(startPane);
		Rectangle r1 = new Rectangle();
		r1.setHeight(675);
		r1.setWidth(1292);
		r1.setFill(Color.WHEAT);
		startStage.setHeight(675);
		startStage.setWidth(1292);
		startStage.setScene(startScene);
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		Image photo1 = new Image("file:tictacphoto.jpg");
		ImageView image1 = new ImageView(photo1);
		image1.setLayoutX(550);
		image1.setLayoutY(90);
		image1.setFitHeight(300); 
		image1.setFitWidth(600);
		startStage.getIcons().add(photo1);
		startStage.setTitle("Tic Tac Toe Game");
		
		//////////////////////////////////////////////////////////////////////////////////////////
		
		Image photo2 = new Image("file:tic.jpg");
		ImageView image2 = new ImageView(photo2);
		image2.setLayoutX(960);
		image2.setLayoutY(430);
		image2.setFitHeight(150); 
		image2.setFitWidth(150);
		
		/////////////////////////////////////////////////////////////////////////////////////////
		
		Font font1 = new Font("Copperplate Gothic Bold",45);
		Font font2 = new Font("Calibri", 40);
		Font font3 = new Font("Comic Sans MS", 30);
		Font fontDesign = new Font("Kristen ITC", 40);
		Font fontBackBtn = new Font("Maiandra GD", 25);
	
		Label lbl1 = new Label("Tic Tac Toe Game");
		lbl1.setLayoutX(30);
		lbl1.setLayoutY(45);
		lbl1.setTextFill(Color.DARKORANGE);
		lbl1.setFont(font1);
		
		Label lbldesign = new Label("Game");
		lbldesign.setFont(fontDesign);
		lbldesign.setTextFill(Color.LIGHTBLUE);
		lbldesign.setLayoutX(1020);
		lbldesign.setLayoutY(300);
		
		Button exitBtn = new Button(" Exit ");
		exitBtn.setFont(fontBackBtn);
		exitBtn.setTextFill(Color.RED);
		exitBtn.setLayoutX(1170);
		exitBtn.setLayoutY(570);

		/////////////////////////////////////////////////////////////////////////////////////////
		
		Label lbl2 = new Label("Choose game mode:");
		lbl2.setFont(font2);
		lbl2.setLayoutX(40);
		lbl2.setLayoutY(240);
		lbl2.setTextFill(Color.WHITE);
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		VBox selectBox = new VBox(25);
		selectBox.setLayoutX(60);
		selectBox.setLayoutY(320);
		
		Button btn1 = new Button("Easy mode");
		btn1.setFont(font3);
		btn1.setTextFill(Color.GREEN);
		
		Button btn2 = new Button("Two human");
		btn2.setFont(font3);
		btn2.setTextFill(Color.BLUE);
		
		Button btn3 = new Button("unbeatable");
		btn3.setFont(font3);
		btn3.setTextFill(Color.RED);
		
		//exit button action
		exitBtn.setOnAction(exit ->{
			
			startStage.close();
		});
		
		selectBox.getChildren().addAll(btn1, btn2, btn3);
		
		startPane.getChildren().addAll(r1, image1, image2, lbl1, lbldesign, lbl2, selectBox, exitBtn);
		
		startStage.show();
		/////////////////////////////____End start stage____////////////////////////////////////////////
		
	
		
		//________________________Easy stage____________________________________________________________
		player1e="you";
		comp= "computer";
		Scene easyScene = new Scene(easyPane);
		Stage easyStage = new Stage();
		Rectangle r2 = new Rectangle();
		r2.setHeight(600);
		r2.setWidth(800);
		r2.setFill(Color.WHEAT);
		easyStage.setHeight(600);
		easyStage.setWidth(800);
		easyStage.setScene(easyScene);
		easyStage.getIcons().add(photo1);
		easyStage.setTitle("Easy mode");
		
		Font fonteasy = new Font("Maiandra GD", 40);

		/////////////////////////////////////////////////////////////////////////////////////
		Label lblesy1 = new Label("Easy mode");
		lblesy1.setFont(fonteasy);
		lblesy1.setLayoutX(260);
		lblesy1.setLayoutY(20);
		lblesy1.setTextFill(Color.GREEN);
		
		/////////////////////////////////////////////////////////////////////////////////////

		Button easyBackBtn = new Button("<Back");
		easyBackBtn.setFont(fontBackBtn);
		easyBackBtn.setTextFill(Color.RED);
		easyBackBtn.setLayoutX(10);
		easyBackBtn.setLayoutY(490);
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		VBox resetBox2 = new VBox(15);
		resetBox2.setLayoutX(350);
		resetBox2.setLayoutY(400);
		
		
		
		
		resetBox2.getChildren().addAll(resultGameEasy);
		
		/////////////////////////////////////////////////////////////////////////////////////

		easyStage.setResizable(false);
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		Rectangle rec = new Rectangle(800,600);
		easyPane.getChildren().addAll(rec);
		
		 check = true;
		 
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		HBox computerBox = new HBox(10);
		computerBox.setLayoutX(20);
		computerBox.setLayoutY(140);
		
		Label player2Comp = new Label("Computer: ");
		player2Comp.setFont(fontOfLabel);
		player2Comp.setTextFill(Color.RED);
		
		Label oComputer = new Label("O");
		oComputer.setFont(fontOfLabel);
		oComputer.setTextFill(Color.RED);

		computerBox.getChildren().addAll(player2Comp, oComputer);
		

		easyPane.getChildren().addAll(r2, lblesy1, easyBackBtn, computerBox, resetBox2);
		TextInputDialog player1es = new TextInputDialog();
        player1es.setTitle("Player 1 Name");
        player1es.setHeaderText("Enter the name for Player 1:");
        player1es.setContentText("Name:");

		/////////////////////////////____End easy stage____////////////////////////////////////////////
		
		
		//________________________Challenge stage____________________________________________________________
		Scene multipleScene = new Scene(multiplePane);
		Stage multipleStage = new Stage();
		Rectangle r3 = new Rectangle();
		r3.setHeight(600);
		r3.setWidth(800);
		r3.setFill(Color.WHEAT);
		multipleStage.setHeight(600);
		multipleStage.setWidth(800);
		multipleStage.setScene(multipleScene);
		multipleStage.getIcons().add(photo1);
		multipleStage.setTitle("Challenge mode");
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		Font fontmultiple = new Font("Maiandra GD", 40);
		
		Label lblmlt1 = new Label("Challenge mode");
		lblmlt1.setFont(fontmultiple);
		lblmlt1.setLayoutX(240);
		lblmlt1.setLayoutY(20);
		lblmlt1.setTextFill(Color.GREEN);
		
		
		/////////////////////////////////////////////////////////////////////////////////////

		Button multipleBackBtn = new Button("<Back");
		multipleBackBtn.setFont(fontBackBtn);
		multipleBackBtn.setTextFill(Color.RED);
		multipleBackBtn.setLayoutX(10);
		multipleBackBtn.setLayoutY(490);
		
		multipleStage.setResizable(false);
		
		////////////////////////////////////////////////////////////////////////////////////
		
		VBox resetBox1 = new VBox(15);
		resetBox1.setLayoutX(350);
		resetBox1.setLayoutY(400);
		
		
		

		
		resetBox1.getChildren().addAll(resultGamelbl2);
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		//Players  
		TextInputDialog player1NameDialog = new TextInputDialog();
        player1NameDialog.setTitle("Player 1 Name");
        player1NameDialog.setHeaderText("Enter the name for Player 1:");
        player1NameDialog.setContentText("Name:");

        TextInputDialog player2NameDialog = new TextInputDialog();
        player2NameDialog.setTitle("Player 2 Name");
        player2NameDialog.setHeaderText("Enter the name for Player 2:");
        player2NameDialog.setContentText("Name:");
		
		multiplePane.getChildren().addAll(r3, lblmlt1, multipleBackBtn, resetBox1);
		
		
		
		/////////////////////////////____End challenge stage____////////////////////////////////////////////
		
		
		//________________________Impossible stage____________________________________________________________
		player1h="you";
		comph= "computer";
		Scene impossibleScene = new Scene(impossiblePane,Color.WHEAT);
		Stage impossibleStage = new Stage();
		impossibleStage.setHeight(600);
		impossibleStage.setWidth(800);
		impossibleStage.setScene(impossibleScene);
		impossibleStage.getIcons().add(photo1);
		impossibleStage.setTitle("Impossible mode");
		Rectangle r4 = new Rectangle();
		r4.setHeight(600);
		r4.setWidth(800);
		r4.setFill(Color.WHEAT);
		
		/////////////////////////////////////////////////////////////////////////////
		
		Font fontimpossible = new Font("Maiandra GD", 40);
		
		Label lblimps1 = new Label("Impossible mode");
		lblimps1.setFont(fontimpossible);
		lblimps1.setLayoutX(240);
		lblimps1.setLayoutY(20);
		lblimps1.setTextFill(Color.GREEN);
		
		impossibleStage.setResizable(false);
		
		/////////////////////////////////////////////////////////////////////////////

		Button impossibleBackBtn = new Button("<Back");
		impossibleBackBtn.setFont(fontBackBtn);
		impossibleBackBtn.setTextFill(Color.RED);
		impossibleBackBtn.setLayoutX(10);
		impossibleBackBtn.setLayoutY(490);
		
		VBox resetBox3 = new VBox(15);
		resetBox3.setLayoutX(350);
		resetBox3.setLayoutY(400);
		
	
		
		resetBox3.getChildren().addAll(resultGamelbl3);
		
		/////////////////////////////////////////////////////////////////////////////
		HBox hard1Box = new HBox(10);
		hard1Box.setLayoutX(20);
		hard1Box.setLayoutY(100);
		
	
			
		/////////////////////////////////////////////////////////////////////////////////////
				
		HBox hard2Box = new HBox(10);
		hard2Box.setLayoutX(20);
		hard2Box.setLayoutY(140);
				
		Label playerTwolblHard = new Label("Computer: ");
		playerTwolblHard.setFont(fontOfLabel);
		playerTwolblHard.setTextFill(Color.RED);
			
		Label playerOlblHard = new Label("O");
		playerOlblHard.setFont(fontOfLabel);
		playerOlblHard.setTextFill(Color.RED);

		hard2Box.getChildren().addAll(playerTwolblHard, playerOlblHard);
		
		impossiblePane.getChildren().addAll(r4, lblimps1, resetBox3, impossibleBackBtn,hard1Box , hard2Box);
		TextInputDialog player1har = new TextInputDialog();
        player1har.setTitle("Player 1 Name");
        player1har.setHeaderText("Enter the name for Player 1:");
        player1har.setContentText("Name:");
		
		/////////////////////////////____End impossible stage____////////////////////////////////////////////
		
		
		//Buttons Actions(in start stage)
		btn1.setOnAction(e1 -> {
		    startStage.close();
		    Optional<String> result1 = player1es.showAndWait();
            player1e = result1.orElse("Player 1");
            
           HBox p1Box = new HBox(10);
    		p1Box.setLayoutX(20);
    		p1Box.setLayoutY(100);
    		
    		Label playerOne = new Label(player1e);
    		playerOne.setFont(fontOfLabel);
    		playerOne.setTextFill(Color.GREEN);
    		
    		Label playerXlbl = new Label("X");
    		playerXlbl.setFont(fontOfLabel);
    		playerXlbl.setTextFill(Color.GREEN);
    		
    		p1Box.getChildren().addAll(playerOne, playerXlbl);
    		HBox p2Box = new HBox(10);
    		p2Box.setLayoutX(20);
    		p2Box.setLayoutY(140);
 
    		easyPane.getChildren().addAll( p1Box, p2Box);
		    char startingPlayer = chooseStartingPlayeresay();
		    easyStage.show();
		    easyPane.getChildren().addAll(buildBoard1(startingPlayer));
		    mode = 1;
		});
		
		 btn2.setOnAction(e2 -> {
	            startStage.close();

	            // Get Player 1 name
	            
	           
	    
	            Optional<String> result1 = player1NameDialog.showAndWait();
	            player1Name = result1.orElse("Player 1");

	            // Get Player 2 name
	            Optional<String> result2 = player2NameDialog.showAndWait();
	           player2Name = result2.orElse("Player 2");
	           HBox p1Box = new HBox(10);
	    		p1Box.setLayoutX(20);
	    		p1Box.setLayoutY(100);
	    		
	    		Label playerOne = new Label(player1Name);
	    		playerOne.setFont(fontOfLabel);
	    		playerOne.setTextFill(Color.GREEN);
	    		
	    		Label playerXlbl = new Label("X");
	    		playerXlbl.setFont(fontOfLabel);
	    		playerXlbl.setTextFill(Color.GREEN);
	    		
	    		p1Box.getChildren().addAll(playerOne, playerXlbl);
	    		HBox p2Box = new HBox(10);
	    		p2Box.setLayoutX(20);
	    		p2Box.setLayoutY(140);
	    		
	    		Label playerTwo = new Label(player2Name );
	    		playerTwo.setFont(fontOfLabel);
	    		playerTwo.setTextFill(Color.RED);
	    		
	    		Label playerOlbl = new Label("O");
	    		playerOlbl.setFont(fontOfLabel);
	    		playerOlbl.setTextFill(Color.RED);

	    		p2Box.getChildren().addAll(playerTwo, playerOlbl);
	    		multiplePane.getChildren().addAll( p1Box, p2Box);
	    		
	            char startingPlayer = chooseStartingPlayer();
	            multipleStage.show();
	            multiplePane.getChildren().addAll(buildBordCha(startingPlayer));
	            mode = 3;
	        });

		multipleBackBtn.setOnAction(b1 ->{
			
			multipleStage.close();
			startStage.show();
		});
		

		btn3.setOnAction(e3 ->{
		    startStage.close();
		    Optional<String> result1h = player1har.showAndWait();
		    player1h = result1h.orElse("Player");

            // Get Player 2 name
            
           HBox p1Box = new HBox(10);
    		p1Box.setLayoutX(20);
    		p1Box.setLayoutY(100);
    		
    		Label playerOne = new Label(player1h);
    		playerOne.setFont(fontOfLabel);
    		playerOne.setTextFill(Color.GREEN);
    		
    		Label playerXlbl = new Label("X");
    		playerXlbl.setFont(fontOfLabel);
    		playerXlbl.setTextFill(Color.GREEN);
    		
    		p1Box.getChildren().addAll(playerOne, playerXlbl);
    		HBox p2Box = new HBox(10);
    		p2Box.setLayoutX(20);
    		p2Box.setLayoutY(140);
 
    		impossiblePane.getChildren().addAll( p1Box, p2Box);
		    char startingPlayer = chooseStartingPlayerhard();
		    impossibleStage.show();
		    impossiblePane.getChildren().addAll(buildBord(startingPlayer));

			mode = 2;
		});
		
		
		
		//Back buttons actions(in all stages)
		easyBackBtn.setOnAction(b1 ->{
			
			easyStage.close();
			startStage.show();
		});
		
		multipleBackBtn.setOnAction(b1 ->{
			
			multipleStage.close();
			startStage.show();
		});

		impossibleBackBtn.setOnAction(b1 ->{
	
			impossibleStage.close();
			startStage.show();
		});
		

		
	}//end Start
	
	
	
	//_________Methods_________________________________________________________________________________
	
	//randomAi method(Easy mode)
	int step = 8;
	public void randomAi(Board board, int pos) {
	    int[] array = new int[9];
	    int count = 0;

	    for (int i = 0; i < 9; i++) {
	        if (board.arrRectangle[i].check) {
	            array[count] = i;
	            count++;
	        }
	    }

	    Random randomNum = new Random();
	    if (count != 0) {
	        if (!check) {
	            int randomIndex = array[randomNum.nextInt(count)];
	            board.arrRectangle[randomIndex].btn.fire();

	            if (checkWinner('o')) {
	                resultGameEasy.setTextFill(Color.RED);
	                resultGameEasy.setText("Game Over .-.");
	                resetGame();
	            } else if (!checkWinner('x') && !checkWinner('o') && !board.anySpace()) {
	                resultGameEasy.setText("Symmetry!");
	                resultGameEasy.setTextFill(Color.BLUE);
	                resetGame();
	            }
	        }
	    }

	    step -= 2;
	}
	
	
    private char chooseStartingPlayeresay() {
        List<String> choices = List.of(player1e, comp);
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Choose Starting Player");
        dialog.setHeaderText("Select who will start playing first:");

        Optional<String> result = dialog.showAndWait();
        return result.map(choice -> choice.equals(player1e) ? 'x' : 'o').orElse('x');
    }
    
   
    private VBox buildBoard1(char startingPlayer) {
        check = true;
        board = new Board();
        check = startingPlayer == 'x';
        VBox vbox = new VBox(3);
      
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            HBox hbox = new HBox(5);

            for (int j = 0; j < 3; j++) {
                board.arrRectangle[counter] = new RectangleTec();

                int tempNum = counter;

                board.arrRectangle[counter].btn.setOnAction(e -> {
                    x = new Label("X");
                    x.setFont(fontOfLabel);
                    x.setTextFill(Color.GREEN);

                    o = new Label("O");
                    o.setTextFill(Color.RED);
                    o.setFont(fontOfLabel);

                    if (check) {
                        check = false;
                        board.arrRectangle[tempNum].stack.getChildren().add(x);
                        board.arrRectangle[tempNum].check = false;
                        board.arrRectangle[tempNum].xo = 'x';

                        if (mode == 1) {
                            if (checkWinner('x')) {
                                resultGameEasy.setTextFill(Color.GREEN);
                                resultGameEasy.setText("You Win ._.");
                                resetGame();
                            } else if (checkWinner('o')) {
                                resultGameEasy.setTextFill(Color.RED);
                                resultGameEasy.setText("Game Over .-.");
                                resetGame();
                            } else if (!checkWinner('x') && !checkWinner('o') && !board.anySpace()) {
                                resultGameEasy.setText("Symmetry!");
                                resultGameEasy.setTextFill(Color.BLUE);
                                resetGame();
                            } else {
                            	randomAi(board, tempNum);
                            }
                        }

                        if (!checkWinner('x') && !checkWinner('o') && !board.anySpace()) {
                            resultGameEasy.setText("Symmetry!");
                            resultGameEasy.setTextFill(Color.BLUE);
                        }

                        checkWinToSetColor('x');
                    } else {
                        check = true;
                        board.arrRectangle[tempNum].stack.getChildren().add(o);
                        board.arrRectangle[tempNum].check = false;
                        board.arrRectangle[tempNum].xo = 'o';

                        checkWinToSetColor('o');
                    }

                    board.arrRectangle[tempNum].btn.setDisable(true);
                });

                hbox.getChildren().add(board.arrRectangle[counter].stack);
                counter++;
            }

            vbox.getChildren().add(hbox);
        }

        vbox.setLayoutX(250);
        vbox.setLayoutY(100);

        randomAi(board, counter);
        return vbox;
    }
    ////////////////////////////////////////////////////////////////////////////////// end 
    
    private char chooseStartingPlayerhard() {
        List<String> choices = List.of(player1h, comph);
        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Choose Starting Player");
        dialog.setHeaderText("Select who will start playing first:");

        Optional<String> result = dialog.showAndWait();
        return result.map(choice -> choice.equals(player1h) ? 'x' : 'o').orElse('x');
    }
    
    public int evaluateBoard12(Board board) {
        if (checkWinner('o')) {
          
            return 1;
        } else if (checkWinner('x')) {
            
            return -1;
        }

       
        return 0;
    }

    
	//MinMax method (Hard mode)
    public int minMax(Board board, boolean isMax) 
    {

        int boardVal = evaluateBoard12(  board);
       

        // Terminal node (win/lose/draw) or max depth reached.
        if (Math.abs(boardVal) == 1 || !board.anySpace()) 
        	
        {
        	
            return boardVal;
            
        }
    	
        //find the maximum value
        if (isMax) 
        {
            int maxValue = Integer.MIN_VALUE;
            
            for (int i = 0; i < board.getWidth(); i++) 
            {
               
                    if (!board.isFull(i)) 
                    {
                        board.setValue(i, 'o');
                        maxValue = Math.max(maxValue, minMax(board, false));
                        board.setValue(i, '\0'); 
                    }
            }//end for

            return maxValue;
            
            //find the minimum value
        }
        else 
        {
            int minValue = Integer.MAX_VALUE;
            
            for (int i = 0; i < board.getWidth(); i++) 
            {
              
                    if (!board.isFull(i)) 
                    {
                        board.setValue(i, 'x');
                        minValue = Math.min(minValue, minMax(board, true));
                        board.setValue(i, '\0');    
                }
            }

            return minValue;
        }
        
    }//end MinMax method
    

    public int getBestMove(Board board) {
        int bestMove = 0;
        int bestValue = Integer.MIN_VALUE;

        for (int i = 0; i < board.getWidth(); i++) {
            if (!board.isFull(i)) {
                board.setValue(i, 'o');
                int moveValue = minMax(board, false);
                board.setValue(i, '\0');

               
                System.out.println("Move " + i + " - Score: " + moveValue);

                if (moveValue > bestValue) {
                    bestMove = i;
                    bestValue = moveValue;
                }
            }
        }

        return bestMove;
    }

   

    //Build Board method
	public VBox buildBord(char startingPlayer) {
	    check = true;
	    board = new Board();
	    check = startingPlayer == 'x';
	    VBox vbox = new VBox(3);

	    int counter = 0;

	    for (int i = 0; i < 3; i++) {
	        HBox hbox = new HBox(5);

	        for (int j = 0; j < 3; j++) {
	            board.arrRectangle[counter] = new RectangleTec();
	            int tempNum = counter;

	            board.arrRectangle[counter].btn.setOnAction(e -> {
	                x = new Label("X");
	                x.setFont(fontOfLabel);
	                x.setTextFill(Color.GREEN);

	                o = new Label("O");
	                o.setTextFill(Color.RED);
	                o.setFont(fontOfLabel);

	                // Check
	                if (check) {
	                    check = false;

	                    board.arrRectangle[tempNum].stack.getChildren().add(x);
	                    board.arrRectangle[tempNum].check = false;
	                    board.arrRectangle[tempNum].xo = 'x';

	                    if (mode == 2) {
	                        int bestMove = getBestMove(board);
	                        board.arrRectangle[bestMove].btn.fire();
	                    }
	                    checkWinToSetColor('x');
	                } else {
	                    check = true;

	                    board.arrRectangle[tempNum].stack.getChildren().add(o);
	                    board.arrRectangle[tempNum].check = false;
	                    board.arrRectangle[tempNum].xo = 'o';

	                    checkWinToSetColor('o');
	                }

	                board.arrRectangle[tempNum].btn.setDisable(true);
	                if(checkWinner('o'))
					{
						resultGamelbl3.setText("Game Over .-.");
						resultGamelbl3.setTextFill(Color.RED);
						resetGame();
					}
					else if(!checkWinner('x') && !checkWinner('o') && !board.anySpace())
					{
						resultGamelbl3.setText("Symmetry!");
						resultGamelbl3.setTextFill(Color.BLUE);
						resetGame();
					}
	            });

	            hbox.getChildren().add(board.arrRectangle[counter].stack);
	            counter++;
	        }

	        vbox.getChildren().add(hbox);
	    }

	    vbox.setLayoutX(250);
	    vbox.setLayoutY(100);
	   randomAi(board, counter);
	    return vbox;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	private char chooseStartingPlayer() {
	    List<String> choices = List.of(player1Name, player2Name);
	    ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
	    dialog.setTitle("Choose Starting Player");
	    dialog.setHeaderText("Select who will start playing first:");

	    Optional<String> result = dialog.showAndWait();
	    return result.map(choice -> choice.equals(player1Name) ? 'x' : 'o').orElse('x');
	}
	
	public VBox buildBordCha(char startingPlayer) {

		  check = true;
	        board = new Board();

	        VBox vbox = new VBox(3);
	        check = startingPlayer == 'x';
	        int counter = 0;

	        for (int i = 0; i < 3; i++) {
	            HBox hbox = new HBox(5);

	            for (int j = 0; j < 3; j++) {
	                board.arrRectangle[counter] = new RectangleTec();

	                int tempNum = counter;

	                board.arrRectangle[counter].btn.setOnAction(e -> {
	                    {
	                        x = new Label("X");
	                        x.setFont(fontOfLabel);
	                        x.setTextFill(Color.GREEN);

	                        o = new Label("O");
	                        o.setTextFill(Color.RED);
	                        o.setFont(fontOfLabel);

	                        if (check) {
	                            check = false;
	                            board.arrRectangle[tempNum].stack.getChildren().add(x);
	                            board.arrRectangle[tempNum].check = false;
	                            board.arrRectangle[tempNum].xo = 'x';

	                            if (mode == 3) {
	                                if (checkWinner('x')) {
	                                    resultGamelbl2.setText(player1Name + " is the Winner ._.");
	                                    resultGamelbl2.setTextFill(Color.GREEN);
	                                    resetGame();
	                                    
	                                } else if (checkWinner('o')) {
	                                    resultGamelbl2.setText(player2Name + " is the Winner ._.");
	                                    resultGamelbl2.setTextFill(Color.GREEN);
	                                    resetGame();
	                                  
	                                } else if (!board.anySpace() && !checkWinner('o') && !checkWinner('x')) {
	                                    resultGamelbl2.setText("Symmetry!");
	                                    resultGamelbl2.setTextFill(Color.BLUE);
	                                    resetGame();
	                                 
	                                }
	                            }

	                            if (!checkWinner('x') && !checkWinner('o') && !board.anySpace()) {
	                                resultGamelbl2.setText("Symmetry!");
	                                resultGamelbl2.setTextFill(Color.BLUE);
	                                resetGame();
	                            
	                            }

	                            checkWinToSetColor('x');
	                        } else {
	                            check = true;
	                            board.arrRectangle[tempNum].stack.getChildren().add(o);
	                            board.arrRectangle[tempNum].check = false;
	                            board.arrRectangle[tempNum].xo = 'o';

	                            if (mode == 3) {
	                                if (checkWinner('x')) {
	                                    resultGamelbl2.setText(player1Name + " is the Winner ._.");
	                                    resultGamelbl2.setTextFill(Color.GREEN);
	                                    resetGame();
	                                  
	                                } else if (checkWinner('o')) {
	                                    resultGamelbl2.setText(player2Name + " is the Winner ._.");
	                                    resultGamelbl2.setTextFill(Color.GREEN);
	                                    resetGame();
	                                
	                                } else if (!board.anySpace() && !checkWinner('o') && !checkWinner('x')) {
	                                    resultGamelbl2.setText("Symmetry!");
	                                    resultGamelbl2.setTextFill(Color.BLUE);
	                                    resetGame();
	                                 
	                                }
	                            }

	                            checkWinToSetColor('o');
	                        }

	                        board.arrRectangle[tempNum].btn.setDisable(true);
	                    }
	                });

	                hbox.getChildren().add(board.arrRectangle[counter].stack);
	                counter++;
	            }

	            vbox.getChildren().add(hbox);

	        }

	        vbox.setLayoutX(250);
	        vbox.setLayoutY(100);

	        return vbox;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Reset method
	   private void resetGame() {
	        board = new Board();
	      //  resultGamelbl3.setText(""); 
	        for (int i = 0; i < board.arrRectangle.length; i++) {
	            board.arrRectangle[i] = new RectangleTec();

	            board.arrRectangle[i].check = true;
	            board.arrRectangle[i].stack.getChildren().clear();
	            board.arrRectangle[i].stack.getChildren().addAll(board.arrRectangle[i].rec, board.arrRectangle[i].btn);
	            board.arrRectangle[i].xo = '\0';
	        }

	        if (checkWinner('o') || checkWinner('x') || !board.anySpace()) {
	            step = 8;
	        }

	        
	    }
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//Check who is winner method
	public boolean checkWinToSetColor(char a) 
	{

			if(board.arrRectangle[0].xo == a && board.arrRectangle[1].xo == a && board.arrRectangle[2].xo == a)
			{
				board.arrRectangle[0].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[1].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[2].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[3].xo == a && board.arrRectangle[4].xo == a && board.arrRectangle[5].xo == a)
			{
				board.arrRectangle[3].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[5].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[6].xo == a && board.arrRectangle[7].xo == a && board.arrRectangle[8].xo == a)
			{
				board.arrRectangle[6].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[7].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[8].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[0].xo == a && board.arrRectangle[3].xo == a && board.arrRectangle[6].xo == a)
			{
				board.arrRectangle[0].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[3].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[6].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[1].xo == a && board.arrRectangle[4].xo == a && board.arrRectangle[7].xo == a)
			{
				board.arrRectangle[1].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[7].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[2].xo == a && board.arrRectangle[5].xo == a && board.arrRectangle[8].xo == a)
			{
				board.arrRectangle[2].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[5].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[8].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[0].xo == a && board.arrRectangle[4].xo == a && board.arrRectangle[8].xo == a)
			{
				board.arrRectangle[0].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[8].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arrRectangle[2].xo == a && board.arrRectangle[4].xo == a && board.arrRectangle[6].xo == a)
			{
				board.arrRectangle[2].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arrRectangle[6].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			
		return false;
		
	}//end Check who is winner method
		
	//Another check method
	public boolean checkWinner(char b) {

		if(board.arrRectangle[0].xo == b && board.arrRectangle[1].xo == b && board.arrRectangle[2].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[3].xo == b && board.arrRectangle[4].xo == b && board.arrRectangle[5].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[6].xo == b && board.arrRectangle[7].xo == b && board.arrRectangle[8].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[0].xo == b && board.arrRectangle[3].xo == b && board.arrRectangle[6].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[1].xo == b && board.arrRectangle[4].xo == b && board.arrRectangle[7].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[2].xo == b && board.arrRectangle[5].xo == b && board.arrRectangle[8].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[0].xo == b && board.arrRectangle[4].xo == b && board.arrRectangle[8].xo == b)
		{
			return true;
		}
		else if(board.arrRectangle[2].xo == b && board.arrRectangle[4].xo == b && board.arrRectangle[6].xo == b)
		{
			return true;
		}
		
		return false;
	
	}//end Another check method
		
	
	
}//end class ._.
