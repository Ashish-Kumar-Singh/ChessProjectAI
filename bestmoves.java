public class bestmoves{
    Move move;
    double strength;

    public bestmoves(Move x,double y){
        move =x;
        strength=y;
    }
    
    public Move getMove(){
        return move;
      }
    
      public double getstrength(){
        return strength;
      }
}