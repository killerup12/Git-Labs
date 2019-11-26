package People;

public interface HumanInterface
{
    String SayOk(int degreeOfAgreement);
     String TakeHand(String name);
      String CheckMood(boolean mood);    //Displays the mood of the character
       String Pronoun(String gender);    //Changes something to the corresponding pronoun
      String Prepositions(String pronoun);    //Puts the appropriate preposition
     String GoTo(String place, int height);    //Character movement
    void UpDown(int hight);    //Changes character height
     String RelativeLevel(int hight1, int hight2);    //Compares the height of different subjects
      String Play(String game ,String host, String partner);    //Unused method
       String SwallowWords();
      String Laugh();
     String Cry();
    String MakeASound(String gender);
     String WashDishes();
}
