package check;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class BoardFrame extends JFrame {
    
    public BoardFrame(int boardSize){
        this.boardSize=boardSize;
        initComp();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComp() {
       if(boardSize == 8){
           setResizable(false);        // δεν επιτρέπει το JFrame να αλλάζει μέγεθος
        wp = new ImageIcon(getClass().getResource("/images/white.png"));
        bp = new ImageIcon(getClass().getResource("/images/black.png"));
        wd = new ImageIcon(getClass().getResource("/images/whitentama.png"));
        bd = new ImageIcon(getClass().getResource("/images/blackntama.png"));
        endwp=12;
        endbp=12;
        board = new JPanel(new GridLayout(8, 8));
        pa = new JPanel[8][8];
        clr=wp;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JPanel p = new JPanel(new BorderLayout());
                JLabel l = new JLabel();
                p.add(l);
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    p.setBackground(Color.lightGray);
                } else {
                    p.setBackground(Color.darkGray);
                }

                p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                p.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        doClicked(e);
                    }
                });
                pa[i][j] = p;
                board.add(p);
            }
        }

        // τοποθετεί τα άσπρα πούλια
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2 == 0 || j % 2 == 0) && (i % 2 == 1 || j % 2 == 1)) {
                    JPanel p = pa[i][j];
                    JLabel l = (JLabel) p.getComponent(0);
                    l.setIcon(wp);
                }
            }
        }
        // τοποθετεί τα μαύρα πούλια        
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2 == 0 || j % 2 == 0) && (i % 2 == 1 || j % 2 == 1)) {
                    JPanel p = pa[i][j];
                    JLabel l = (JLabel) p.getComponent(0);
                    l.setIcon(bp);
                }
            }
        }

        add(board, BorderLayout.CENTER);
        setSize(540, 540);
       } 
       if(boardSize == 10){
           setResizable(false);        // δεν επιτρέπει το JFrame να αλλάζει μέγεθος
        wp = new ImageIcon(getClass().getResource("/images/white.png"));
        bp = new ImageIcon(getClass().getResource("/images/black.png"));
        wd = new ImageIcon(getClass().getResource("/images/whitentama.png"));
        bd = new ImageIcon(getClass().getResource("/images/blackntama.png"));
        endwp=20;
        endbp=20;
        board = new JPanel(new GridLayout(10, 10));
        pa = new JPanel[10][10];
        clr=wp;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JPanel p = new JPanel(new BorderLayout());
                JLabel l = new JLabel();
                p.add(l);
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    p.setBackground(Color.lightGray);
                } else {
                    p.setBackground(Color.darkGray);
                }

                p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                p.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        doClicked(e);
                    }
                });
                pa[i][j] = p;
                board.add(p);
            }
        }

        // τοποθετεί τα άσπρα πούλια
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i % 2 == 0 || j % 2 == 0) && (i % 2 == 1 || j % 2 == 1)) {
                    JPanel p = pa[i][j];
                    JLabel l = (JLabel) p.getComponent(0);
                    l.setIcon(wp);
                }
            }
        }
        // τοποθετεί τα μαύρα πούλια        
        for (int i = 6; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i % 2 == 0 || j % 2 == 0) && (i % 2 == 1 || j % 2 == 1)) {
                    JPanel p = pa[i][j];
                    JLabel l = (JLabel) p.getComponent(0);
                    l.setIcon(bp);
                }
            }
        }

        add(board, BorderLayout.CENTER);
        setSize(700, 700);
    }

    }
    
     private void doClicked(MouseEvent e) {
        JPanel p = (JPanel) e.getSource();
        JLabel l = (JLabel) p.getComponent(0);
       
        hand=l.getIcon();
        Color check= p.getBackground ();
        Color d=new Color(255,0,0);
        if (slct==0 && hand!=null){
         if ((l.getIcon() == clr)  || ((clr==wp) && (l.getIcon()==wd)) || ((clr==bp) && (l.getIcon()==bd))) {
            slct=2;
            if((l.getIcon()==bd) || (l.getIcon()==wd)) dame=1;
            else dame=0;
            Color c=new Color(255,0,0);
            bg=p.getBackground();
            p.setBackground(c);
            de=p.getBackground();
            temp=p;
            templ=l;
             
            for(i=0;i<boardSize;i++){
                for(j=0;j<boardSize;j++){
                    if(pa[i][j] == p){
                        y=i;
                        x=j;
                    }
                }
            }
         }
        // System.out.println("mouseClicked at: x="+x+" y="+y);
        }
       if(clr==wp && dame==0){
           for(i=0;i<boardSize;i++){
                for(j=0;j<boardSize;j++){
                    if(pa[i][j] == p){
                        movey=i;
                        movex=j;
                    }
                }
            }
       
         if(((x+2==movex)&&(y+2==movey)) || ((x-2==movex)&&(y+2==movey))){
            if(((x+2==movex)&&(y+2==movey))){   
             fagwp3=pa[y+2][x+2];
            ant3=(JLabel) fagwp3.getComponent(0);  
            fagwp2=pa[y+1][x+1];
            ant2=(JLabel) fagwp2.getComponent(0);
             if((pa[x+2][y+2] == pa[movex][movey] && ant3.getIcon()!=bp && ant3.getIcon()!=wp && ant2.getIcon()==bp) || (pa[x+2][y+2] == pa[movex][movey] && ant3.getIcon()!=bd && ant3.getIcon()!=wd && ant2.getIcon()==bd)){
            
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             if(movey==boardSize-1) l.setIcon(wd);
             else l.setIcon(clr);
             templ.setIcon(null);
             clr=bp;
             ant2.setIcon(null);
             endbp--;
             }}else{
            if(((x-2==movex)&&(y+2==movey))){   
            fagwp3=pa[y+2][x-2];
            ant3=(JLabel) fagwp3.getComponent(0);  
            fagwp1=pa[y+1][x-1];
            ant1=(JLabel) fagwp1.getComponent(0);
             if((pa[x-2][y+2] == pa[movex][movey] && ant3.getIcon()!=bp && ant3.getIcon()!=wp && ant1.getIcon()==bp) || (pa[x-2][y+2] == pa[movex][movey] && ant3.getIcon()!=bd && ant3.getIcon()!=wd && ant1.getIcon()==bd)){
            
            temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            if(movey==boardSize-1) l.setIcon(wd);
             else l.setIcon(clr);
             templ.setIcon(null);
             clr=bp;
             ant1.setIcon(null);
             endbp--;
                 }
            }
             }
             slct=0;
         
         
        } else {
           
        if((slct==1 && hand==null)||(p.getBackground()==de)){
         if (p.getBackground()==bg){
           if (l.getIcon() == null) {
               
               
              
              //System.out.println("mouseClicked at: movex="+movex+" movey="+movey);
              if(x==boardSize-1){
                  if((pa[x-1][y+1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            if(movey==boardSize-1) l.setIcon(wd);
            else l.setIcon(clr);
             templ.setIcon(null);
             clr=bp;
             slct=0;
          
              }
              } else {
              if((pa[x+1][y+1] == pa[movex][movey]) || (pa[x-1][y+1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             if(movey==boardSize-1) l.setIcon(wd);
             else l.setIcon(clr);
             templ.setIcon(null);
             clr=bp;
             slct=0;
             
              }
              }
         } else {
             JOptionPane.showMessageDialog(this, "Block taken!", "error", JOptionPane.WARNING_MESSAGE);
           }
       }
      }
       }
        if(p.getBackground()==de && l.getIcon() != null && slct==1){
            p.setBackground(Color.darkGray);
             if(movey==boardSize-1) l.setIcon(wd);
            else l.setIcon(clr);
             slct=0;
        }
        
        if (slct==2 && hand!=null)
            slct=1;
      }  
       
       if(clr==bp && dame==0){
             
              for(i=0;i<boardSize;i++){
                for(j=0;j<boardSize;j++){
                    if(pa[i][j] == p){
                        movey=i;
                        movex=j;
                    }
                }
            }
             
          if(((x+2==movex)&&(y-2==movey)) || ((x-2==movex)&&(y-2==movey))){
            if(((x-2==movex)&&(y-2==movey))){  
             fagwp4=pa[y-2][x-2];
            ant4=(JLabel) fagwp4.getComponent(0);  
            fagwp2=pa[y-1][x-1];
            ant2=(JLabel) fagwp2.getComponent(0);
             if((pa[x-2][y-2] == pa[movex][movey] && ant4.getIcon()!=wp && ant4.getIcon()!=bp && ant2.getIcon()==wp) || (pa[x-2][y-2] == pa[movex][movey] && ant4.getIcon()!=wd && ant4.getIcon()!=bd && ant2.getIcon()==wd)){
            
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            if(movey==0) l.setIcon(bd);
                 else l.setIcon(clr);
             templ.setIcon(null);
             clr=wp;
             ant2.setIcon(null);
             endwp--;
             }}else{
             if(((x+2==movex)&&(y-2==movey))){  
            fagwp4=pa[y-2][x+2];
            ant4=(JLabel) fagwp4.getComponent(0);
            fagwp1=pa[y-1][x+1];
            ant1=(JLabel) fagwp1.getComponent(0);
             if((pa[x+2][y-2] == pa[movex][movey] && ant4.getIcon()!=wp && ant4.getIcon()!=bp && ant1.getIcon()==wp) || (pa[x+2][y-2] == pa[movex][movey] && ant4.getIcon()!=wd && ant4.getIcon()!=bd && ant1.getIcon()==wd)){
            
            temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            if(movey==0) l.setIcon(bd);
                 else l.setIcon(clr);
             templ.setIcon(null);
             clr=wp;
             ant1.setIcon(null);
             endwp--;
                 }
             }
             }
             slct=0;
             
         } else {
        if((slct==1 && hand==null)||(p.getBackground()==de)){
         if (p.getBackground()==bg){
           if (l.getIcon() == null) {
              //System.out.println("mouseClicked at: movex="+movex+" movey="+movey);
              if(x==boardSize-1){
                  if((pa[x-1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             if(movey==0) l.setIcon(bd);
                 else l.setIcon(clr);
             templ.setIcon(null);
             clr=wp;
             slct=0;
            
              }
              } else {
              if((pa[x+1][y-1] == pa[movex][movey]) || (pa[x-1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             if(movey==0) l.setIcon(bd);
                 else l.setIcon(clr);
             templ.setIcon(null);
             clr=wp;
             slct=0;
            
              }
              }
         } else {
             JOptionPane.showMessageDialog(this, "Block taken!", "error", JOptionPane.WARNING_MESSAGE);
           }
       }
      }
           }
        if(p.getBackground()==de && l.getIcon() != null && slct==1){
            p.setBackground(Color.darkGray);
             if(movey==0) l.setIcon(bd);
              else l.setIcon(clr);
             slct=0;
        }
        
        if (slct==2 && hand!=null)
            slct=1;
      }
        
       
       
       if(clr==wp && dame==1){
           for(i=0;i<boardSize;i++){
                for(j=0;j<boardSize;j++){
                    if(pa[i][j] == p){
                        movey=i;
                        movex=j;
                    }
                }
            }
       
         if(((x+2==movex)&&(y+2==movey)) || ((x-2==movex)&&(y-2==movey)) || ((x-2==movex)&&(y+2==movey)) || ((x+2==movex)&&(y-2==movey))){
            if(((x+2==movex)&&(y+2==movey))){   
             fagwp3=pa[y+2][x+2];
            ant3=(JLabel) fagwp3.getComponent(0);  
            fagwp2=pa[y+1][x+1];
            ant2=(JLabel) fagwp2.getComponent(0);
            
             if((pa[x+2][y+2] == pa[movex][movey] && ant3.getIcon()!=bp && ant3.getIcon()!=wp && ant2.getIcon()==bp) || (pa[x+2][y+2] == pa[movex][movey] && ant3.getIcon()!=bd && ant3.getIcon()!=wd && ant2.getIcon()==bd)){
            
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
             templ.setIcon(null);
             clr=bp;
             ant2.setIcon(null);
             endbp--;
             }}else{
            if(((x-2==movex)&&(y+2==movey))){   
            fagwp3=pa[y+2][x-2];
            ant3=(JLabel) fagwp3.getComponent(0);  
            fagwp1=pa[y+1][x-1];
            ant1=(JLabel) fagwp1.getComponent(0);
             if((pa[x-2][y+2] == pa[movex][movey] && ant3.getIcon()!=bp && ant3.getIcon()!=wp && ant1.getIcon()==bp) || (pa[x-2][y+2] == pa[movex][movey] && ant3.getIcon()!=bd && ant3.getIcon()!=wd && ant1.getIcon()==bd)){
            
            temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
             templ.setIcon(null);
             clr=bp;
             ant1.setIcon(null);
             endbp--;
                 }
            }
             }
            
            if(((x-2==movex)&&(y-2==movey))){   
             fagwp3=pa[y-2][x-2];
            ant3=(JLabel) fagwp3.getComponent(0);  
            fagwp2=pa[y-1][x-1];
            ant2=(JLabel) fagwp2.getComponent(0);
            
             if((pa[x-2][y-2] == pa[movex][movey] && ant3.getIcon()!=bp && ant3.getIcon()!=wp && ant2.getIcon()==bp) || (pa[x-2][y-2] == pa[movex][movey] && ant3.getIcon()!=bd && ant3.getIcon()!=wd && ant2.getIcon()==bd)){
            
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
             templ.setIcon(null);
             clr=bp;
             ant2.setIcon(null);
             endbp--;
             }}else{
            if(((x+2==movex)&&(y-2==movey))){   
            fagwp3=pa[y-2][x+2];
            ant3=(JLabel) fagwp3.getComponent(0);  
            fagwp1=pa[y-1][x+1];
            ant1=(JLabel) fagwp1.getComponent(0);
             if((pa[x+2][y-2] == pa[movex][movey] && ant3.getIcon()!=bp && ant3.getIcon()!=wp && ant1.getIcon()==bp) || (pa[x+2][y-2] == pa[movex][movey] && ant3.getIcon()!=bd && ant3.getIcon()!=wd && ant1.getIcon()==bd)){
            
            temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            l.setIcon(wd);
             templ.setIcon(null);
             clr=bp;
             ant1.setIcon(null);
             endbp--;
                 }
            }
             }
             slct=0;
         
         
        } else {
           
        if((slct==1 && hand==null)||(p.getBackground()==de)){
         if (p.getBackground()==bg){
           if (l.getIcon() == null) {
               
               
              
              //System.out.println("mouseClicked at: movex="+movex+" movey="+movey);
              if(x==boardSize-1){
                  if((pa[x-1][y+1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey]) || (pa[x-1][y-1] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
           
             templ.setIcon(null);
             clr=bp;
             slct=0;
          
              }
              } else {
                  if(x==0 && y==boardSize-1){
                      if((pa[x+1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
                      temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
             
             templ.setIcon(null);
             clr=bp;
             slct=0; }
                  }else
                  if((pa[x-1][y-1] == pa[movex][movey]) ||  (pa[x+1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
                      temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
             
             templ.setIcon(null);
             clr=bp;
             slct=0; 
                  }else{
              if((pa[x+1][y+1] == pa[movex][movey]) || (pa[x-1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey]) || (pa[x-1][y+1] == pa[movex][movey]) || (pa[x+1][y-1] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(wd);
             
             templ.setIcon(null);
             clr=bp;
             slct=0;
             
              }}
              }
         } else {
             JOptionPane.showMessageDialog(this, "Block taken!", "error", JOptionPane.WARNING_MESSAGE);
           }
       }
      }
       }
        if(p.getBackground()==de && l.getIcon() != null && slct==1){
            p.setBackground(Color.darkGray);
              l.setIcon(wd);
             slct=0;
        }
        
        if (slct==2 && hand!=null)
            slct=1;
      }  
       
       if(clr==bp && dame==1){
             
              for(i=0;i<boardSize;i++){
                for(j=0;j<boardSize;j++){
                    if(pa[i][j] == p){
                        movey=i;
                        movex=j;
                    }
                }
            }
             
          if(((x+2==movex)&&(y-2==movey)) || ((x-2==movex)&&(y-2==movey)) ||((x+2==movex)&&(y+2==movey)) || ((x-2==movex)&&(y+2==movey))){
            if(((x-2==movex)&&(y-2==movey))){  
             fagwp4=pa[y-2][x-2];
            ant4=(JLabel) fagwp4.getComponent(0);  
            fagwp2=pa[y-1][x-1];
            ant2=(JLabel) fagwp2.getComponent(0);
             if((pa[x-2][y-2] == pa[movex][movey] && ant4.getIcon()!=wp && ant4.getIcon()!=bp && ant2.getIcon()==wp) || (pa[x-2][y-2] == pa[movex][movey] && ant4.getIcon()!=wd && ant4.getIcon()!=bd && ant2.getIcon()==wd)){
            
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            l.setIcon(bd);
             templ.setIcon(null);
             clr=wp;
             ant2.setIcon(null);
             endwp--;
             }}else{
             if(((x+2==movex)&&(y-2==movey))){  
            fagwp4=pa[y-2][x+2];
            ant4=(JLabel) fagwp4.getComponent(0);
            fagwp1=pa[y-1][x+1];
            ant1=(JLabel) fagwp1.getComponent(0);
             if((pa[x+2][y-2] == pa[movex][movey] && ant4.getIcon()!=wp && ant4.getIcon()!=bp && ant1.getIcon()==wp) || (pa[x+2][y-2] == pa[movex][movey] && ant4.getIcon()!=wd && ant4.getIcon()!=bd && ant1.getIcon()==wd)){
            
            temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(bd);
             templ.setIcon(null);
             clr=wp;
             ant1.setIcon(null);
             endwp--;
                 }
             }
             }
            if(((x+2==movex)&&(y+2==movey))){  
             fagwp4=pa[y+2][x+2];
            ant4=(JLabel) fagwp4.getComponent(0);  
            fagwp2=pa[y+1][x+1];
            ant2=(JLabel) fagwp2.getComponent(0);
             if((pa[x+2][y+2] == pa[movex][movey] && ant4.getIcon()!=wp && ant4.getIcon()!=bp && ant2.getIcon()==wp) || (pa[x+2][y+2] == pa[movex][movey] && ant4.getIcon()!=wd && ant4.getIcon()!=bd && ant2.getIcon()==wd)){
            
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            l.setIcon(bd);
             templ.setIcon(null);
             clr=wp;
             ant2.setIcon(null);
             endwp--;
             }}else{
             if(((x-2==movex)&&(y+2==movey))){  
            fagwp4=pa[y+2][x-2];
            ant4=(JLabel) fagwp4.getComponent(0);
            fagwp1=pa[y+1][x-1];
            ant1=(JLabel) fagwp1.getComponent(0);
             if((pa[x-2][y+2] == pa[movex][movey] && ant4.getIcon()!=wp && ant4.getIcon()!=bp && ant1.getIcon()==wp) || (pa[x-2][y+2] == pa[movex][movey] && ant4.getIcon()!=wd && ant4.getIcon()!=bd && ant1.getIcon()==wd)){
            
            temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(bd);
             templ.setIcon(null);
             clr=wp;
             ant1.setIcon(null);
             endwp--;
                 }
             }
             }
             slct=0;
             
         } else {
        if((slct==1 && hand==null)||(p.getBackground()==de)){
         if (p.getBackground()==bg){
           if (l.getIcon() == null) {
              //System.out.println("mouseClicked at: movex="+movex+" movey="+movey);
              if(x==boardSize-1){
                  if((pa[x-1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             if(movey==0) l.setIcon(bd);
                 else l.setIcon(clr);
             templ.setIcon(null);
             clr=wp;
             slct=0;
            
              }
              } else {
                  if(x==boardSize-1 && y==0){
                      if((pa[x-1][y+1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
                      temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(bd);
             
             templ.setIcon(null);
             clr=wp;
             slct=0; 
                  }
                  }
                  if((pa[x+1][y+1] == pa[movex][movey]) ||  (pa[x-1][y+1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey])){
                      temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
             l.setIcon(bd);
             
             templ.setIcon(null);
             clr=wp;
             slct=0; 
                  }else{
              if((pa[x+1][y+1] == pa[movex][movey]) || (pa[x-1][y-1] == pa[movex][movey]) || (pa[x][y] == pa[movex][movey]) || (pa[x-1][y+1] == pa[movex][movey]) || (pa[x+1][y-1] == pa[movex][movey])){
             temp.setBackground(Color.darkGray);
             p.setBackground(Color.darkGray);
            l.setIcon(bd);
             templ.setIcon(null);
             clr=wp;
             slct=0;
            
              }
              }}
         } else {
             JOptionPane.showMessageDialog(this, "Block taken!", "error", JOptionPane.WARNING_MESSAGE);
           }
       }
      }
           }
        if(p.getBackground()==de && l.getIcon() != null && slct==1){
            p.setBackground(Color.darkGray);
             if(dame==1 && clr==wp) l.setIcon(wd);
              if(dame==1 && clr==bp) l.setIcon(bd);
              else l.setIcon(clr);
             slct=0;
        }
        
        if (slct==2 && hand!=null)
            slct=1;
      } 
       if(endwp==0){
           JOptionPane.showMessageDialog(this, "Player 2 Wins", "Game Over", JOptionPane.WARNING_MESSAGE); 
       }
       if(endbp==0){
           JOptionPane.showMessageDialog(this, "Player 1 Wins", "Game Over", JOptionPane.WARNING_MESSAGE); 
       }
     } 
    
    private Color bg,de;
    private int x,y,i,j,movex,movey,play,endwp,endbp;
    private ImageIcon clr;
    private int slct,dame;
    private int boardSize;
    private JPanel p,temp,fagwp1,fagwp2,fagwp3,fagwp4;
    private JLabel l,templ,ant1,ant2,ant3,ant4;
    private JPanel board,prev;
    private JPanel[][] pa;
    private ImageIcon wp, bp,wd,bd;
    private Icon hand;
}