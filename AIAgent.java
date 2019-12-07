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
    Stack whiteMovestack = whitemoves;
    Stack blackMoves = blackmoves;
    double initialMoveStrength = 0;
    double finalMoveStrength= 0;
    Square blackmove;//stores a random player move from the stack
    Move move2play =null;//the final move to play

    for(int i=0;i<whiteMovestack.size();i++){
      Move selectedMove = (Move)whitemoves.pop();//Selects a random move from the stack
      if ((selectedMove.getStart().getYC() < selectedMove.getLanding().getYC())
            && (selectedMove.getLanding().getXC() == 3) && (selectedMove.getLanding().getYC() == 3)
            || (selectedMove.getLanding().getXC() == 4) && (selectedMove.getLanding().getYC() == 3)
            || (selectedMove.getLanding().getXC() == 3) && (selectedMove.getLanding().getYC() == 4)
            || (selectedMove.getLanding().getXC() == 4) && (selectedMove.getLanding().getYC() == 4)) {
      
              initialMoveStrength = 0.5;
          }
      while(!blackMoves.empty()){//selected move loops through all the black moves and checks which coinciding landing sqare has most points
        blackmove = (Square)blackMoves.pop();
        if((selectedMove.getLanding().getXC() == blackmove.getXC())//if the landing of the selected move is the same as the start of opponent
        && (selectedMove.getLanding().getYC()== blackmove.getYC())){//If the selected moves triestaking a piece
          System.out.println(blackmove.getName());
          System.out.println(selectedMove.getLanding().getName());    
          if(blackmove.getName().equals("BlackQueen")){
              initialMoveStrength = 10;
            }
            else if(blackmove.getName().equals("BlackRook")){
              initialMoveStrength = 6;
            }
            else if(blackmove.getName().equals("BlackBishop"))
            {
              initialMoveStrength = 4;
            }
            else if (blackmove.getName().equals("BlackKnight")){
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
        }
      }     
    

    if(finalMoveStrength > 0){
      System.out.println(finalMoveStrength);
      return move2play;
    }else{
      return selectedMove;
    }
  }
      return move2play;
    
    
  }
  

  public Move twoLevelsDeep(Stack whitemoves, Stack blackmoves){
    Stack whiteMovestack = whitemoves;
    Stack blackMoves = blackmoves;
    double initialMoveStrength = 0;
    double finalMoveStrength= 0;
    Square blackmove;//stores a random player move from the stack
    Move move2play =null;//the final move to play

    for(int i=0;i<whiteMovestack.size();i++){
      Move selectedMove = (Move)whitemoves.pop();//Selects a random move from the stack
      if ((selectedMove.getStart().getYC() < selectedMove.getLanding().getYC())
            && (selectedMove.getLanding().getXC() == 3) && (selectedMove.getLanding().getYC() == 3)
            || (selectedMove.getLanding().getXC() == 4) && (selectedMove.getLanding().getYC() == 3)
            || (selectedMove.getLanding().getXC() == 3) && (selectedMove.getLanding().getYC() == 4)
            || (selectedMove.getLanding().getXC() == 4) && (selectedMove.getLanding().getYC() == 4)) {
      
              initialMoveStrength = 0.5;
          }
      while(!blackMoves.empty()){//selected move loops through all the black moves and checks which coinciding landing sqare has most points
        blackmove = (Square)blackMoves.pop();
        if((selectedMove.getLanding().getXC() == blackmove.getXC())//if the landing of the selected move is the same as the start of opponent
        && (selectedMove.getLanding().getYC()== blackmove.getYC())){//If the selected moves triestaking a piece
          System.out.println(blackmove.getName());
          System.out.println(selectedMove.getLanding().getName());    
          if(blackmove.getName().equals("BlackQueen")){
              initialMoveStrength = 10;
            }
            else if(blackmove.getName().equals("BlackRook")){
              initialMoveStrength = 6;
            }
            else if(blackmove.getName().equals("BlackBishop"))
            {
              initialMoveStrength = 4;
            }
            else if (blackmove.getName().equals("BlackKnight")){
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
        }
      }     
    

    if(finalMoveStrength > 0){
      System.out.println(finalMoveStrength);
      return move2play;
    }else{
      return selectedMove;
    }
  }
      return move2play;
    
    
  }
}
