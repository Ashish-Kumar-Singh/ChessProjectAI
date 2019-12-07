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
    Stack whiteMoves = whitemoves;
    Stack blackMoves = blackmoves;
    int initialMoveStrength = 0;
    int finalMoveStrength= 0;
    Move blackmove;//stores a random player move from the stack
    Move move2play =null;//the final move to play

    while(!whiteMoves.empty()){
      Move selectedMove = (Move)whiteMoves.pop();//Selects a random move from the stack
      move2play = selectedMove;
      while(!blackMoves.empty()){//selected move loops through all the black moves and checks which coinciding landing sqare has most points
        blackmove = (Move)blackMoves.pop();
        if((selectedMove.getLanding().getXC() == blackmove.getLanding().getXC())//if the landing of the selected move is the same as the start of opponent
        && (selectedMove.getLanding().getYC()== blackmove.getLanding().getYC())){//If the selected moves triestaking a piece
            if(blackmove.getLanding().getName().equals("BlackQueen")){
              initialMoveStrength = 9;
            }
            else if(blackmove.getLanding().getName().equals("BlackRook")){
              initialMoveStrength = 5;
            }
            else if((blackmove.getLanding().getName().equals("BlackBishop"))||(blackmove.getLanding().getName().equals("BlackKnight")))
            {
              initialMoveStrength = 3;
            }
            else if(blackmove.getLanding().getName().equals("BlackPawn")){
              initialMoveStrength = 1;
            }
            else if(blackmove.getLanding().getName().equals("BlackKing")){
              initialMoveStrength = 1000;
            }

        }
        if(initialMoveStrength > finalMoveStrength){
          finalMoveStrength = initialMoveStrength;
          move2play = selectedMove;
        }
      }
      
      if(finalMoveStrength > 0){
        return move2play;
      }
      else{
       return selectedMove;
      }
     }
    return move2play;
  }

  public Move twoLevelsDeep(Stack possibilities){
    Move selectedMove = new Move();
    return selectedMove;
  }
}
