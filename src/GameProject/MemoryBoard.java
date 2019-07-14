package GameProject;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@SuppressWarnings("serial")
public class MemoryBoard extends JFrame{


    private List<MemoryCard> cards;
    private MemoryCard selectedCard;
    private MemoryCard c1;
    private MemoryCard c2;
    private Timer t;
    
    private ImageIcon Boo;
    private ImageIcon Bowser;
    private ImageIcon DryBones;
    private ImageIcon Goomba;
    private ImageIcon Koopa;
    private ImageIcon Mushroom;
    private ImageIcon ShyGuy;
    private ImageIcon Toad;
    private ImageIcon Wario;
    private ImageIcon Yoshi;

    public MemoryBoard(){

    	initIcons();
    	
        int pairs = 10;
        List<MemoryCard> cardsList = new ArrayList<MemoryCard>();
        List<Integer> cardVals = new ArrayList<Integer>();

        for (int i = 0; i < pairs; i++){
            cardVals.add(i);
            cardVals.add(i);
        }
        Collections.shuffle(cardVals);

        for (int val : cardVals){
            MemoryCard c = new MemoryCard();
            c.setId(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        //set up the timer
        t = new Timer(350, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);

        //set up the board itself
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4, 5));
        for (MemoryCard c : cards){
            pane.add(c);
        }
        setTitle("Memory Match");
    }

    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            switch(c1.getId())
            {

               case 0 : c1.setIcon(ShyGuy);
               break;
               
               case 1 : c1.setIcon(Boo);
               break;
               
               case 2 : c1.setIcon(Bowser);
               break;
               
               case 3 : c1.setIcon(DryBones);
               break;
               
               case 4 : c1.setIcon(Goomba);
               break;
               
               case 5 : c1.setIcon(Koopa);
               break;
               
               case 6 : c1.setIcon(Mushroom);
               break;
               
               case 7 : c1.setIcon(Toad);
               break;
               
               case 8 : c1.setIcon(Wario);
               break;
               
               case 9 : c1.setIcon(Yoshi);
               break;
                  
               default : System.out.println("This should never happen");
               
            }
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            
            switch(c2.getId())
            {

               case 0 : c2.setIcon(ShyGuy);
               break;
               
               case 1 : c2.setIcon(Boo);
               break;
               
               case 2 : c2.setIcon(Bowser);
               break;
               
               case 3 : c2.setIcon(DryBones);
               break;
               
               case 4 : c2.setIcon(Goomba);
               break;
               
               case 5 : c2.setIcon(Koopa);
               break;
               
               case 6 : c2.setIcon(Mushroom);
               break;
               
               case 7 : c2.setIcon(Toad);
               break;
               
               case 8 : c2.setIcon(Wario);
               break;
               
               case 9 : c2.setIcon(Yoshi);
               break;
                  
               default : System.out.println("This should never happen");
               
            }
            
            t.start();

        }
    }

    public void checkCards(){
        if (c1.getId() == c2.getId()){//match condition
            c1.setEnabled(false); //disables the button
            c2.setEnabled(false);
            c1.setMatched(true); //flags the button as having been matched
            c2.setMatched(true);
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "You win!");
                System.exit(0);
            }
        }

        else{
            c1.setIcon(null); //'hides' text
            c2.setIcon(null);
        }
        c1 = null; //reset c1 and c2
        c2 = null;
    }

    public boolean isGameWon(){
        for(MemoryCard c: this.cards){
            if (c.getMatched() == true){
                return true;
            }
        }
        return false;
    }
    
    private void initIcons() {
    	
        ShyGuy = new ImageIcon(new ImageIcon("ShyGuy.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Boo = new ImageIcon(new ImageIcon("Boo.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Bowser = new ImageIcon(new ImageIcon("Bowser.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        DryBones = new ImageIcon(new ImageIcon("DryBones.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Goomba = new ImageIcon(new ImageIcon("Goomba.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Koopa = new ImageIcon(new ImageIcon("Koopa.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Mushroom = new ImageIcon(new ImageIcon("Mushroom.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Toad = new ImageIcon(new ImageIcon("Toad.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Wario = new ImageIcon(new ImageIcon("Wario.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
        Yoshi = new ImageIcon(new ImageIcon("Yoshi.png").getImage()
                .getScaledInstance(100, 100,
                        Image.SCALE_DEFAULT));
        
    }

}