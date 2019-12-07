import java.util.*;

public class AIAgent{
  Random rand;

  public AIAgent(){
    rand = new Random();
  }

/*
  The method randomMove takes as input a stack of potential moves that the AI agent
  can make. The agent uses a rondom number generator to randomly select a move from
  the inputted Stack and returns this to the calling agent.
*/

  public Move randomMove(Stack possibilities){

    int moveID = rand.nextInt(possibilities.size());
    System.out.println("Agent randomly selected move : "+moveID);
    for(int i=1;i < (possibilities.size()-(moveID));i++){
      possibilities.pop();
    }
    Move selectedMove = (Move)possibilities.pop();
    return selectedMove;
  }

  public Move nextBestMove(Stack whitemoves, Stack blackmoves){
    //Use the king method and add numbers to them
    //Pawn - 1 point
    //Knight - 3 points
    //Bishop - 3 points
    //Rook - 5 points
    //Queen - 9 points
    //King = 1000 point(Instant win)
    Stack whiteMovestack = (Stack)whitemoves.clone();
    Stack blackMoves = blackmoves;
    double initialMoveStrength = 0;
    double finalMoveStrength= 0;
    Move selectedMove;
    Move whitemove;
    Sqaure blackmove;//stores a random player move from the stack
    Move move2play =null;//the final move to play

    while(!whiteMovestack.empty()){
      whitemove = (Move)whiteMove.pop();//Selects a random move from the stack
      selectedMove = whitemove;
    //   if ((selectedMove.getStart().getYC() < selectedMove.getLanding().getYC())
    //   && (selectedMove.getLanding().getXC() == 3) && (selectedMove.getLanding().getYC() == 3)
    //   || (selectedMove.getLanding().getXC() == 4) && (selectedMove.getLanding().getYC() == 3)
    //   || (selectedMove.getLanding().getXC() == 3) && (selectedMove.getLanding().getYC() == 4)
    //   || (selectedMove.getLanding().getXC() == 4) && (selectedMove.getLanding().getYC() == 4)) {

    //     initialMoveStrength = 1;

    //     if(initialMoveStrength > finalMoveStrength){
    //       finalMoveStrength = initialMoveStrength;
    //       move2play = selectedMove;
    //     }
    // }
      while(!blackMoves.empty()){//selected move loops through all the black moves and checks which coinciding landing sqare has most points
        initialMoveStrength=0;
        blackmove = (Square)blackMoves.pop();
        if((selectedMove.getLanding().getXC() == blackmove.getXC())//if the landing of the selected move is the same as the start of opponent
        && (selectedMove.getLanding().getYC()== blackmove.getYC())){//If the selected moves triestaking a piece
            if(blackmove.getName().equals("BlackQueen")){
              initialMoveStrength = 10;
            }
            else if(blackmove.getName().equals("BlackRook")){
              initialMoveStrength = 6;
            }
            else if((blackmove.getName().equals("BlackBishop"))||(blackmove.getLanding().getName().equals("BlackKnight")))
            {
              initialMoveStrength = 4;
            }
            else if(blackmove.getName().equals("BlackPawn")){
              initialMoveStrength = 2;
            }
            else if(blackmove.getName().equals("BlackKing")){
              initialMoveStrength = 1000;
            }

        }
        if(initialMoveStrength > finalMoveStrength){
          finalMoveStrength = initialMoveStrength;
          move2play = selectedMove;
          System.out.println("||||||||||||||||||||||||||");
        }
      }     
     }
     if(finalMoveStrength > 0){
      System.out.println(finalMoveStrength);
      System.out.println("--+++++++++++++++++++++++++++++++++++--");
      return move2play;
    }
    else{
      System.out.println("random shit");
      return randomMove(whiteMovestack);
    }
     
    
  }

  public Move twoLevelsDeep(Stack possibilities){
    Move selectedMove = new Move();
    return selectedMove;
  }
}
