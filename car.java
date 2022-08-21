import java.awt.*;
import java.awt.event.*;

public class car extends Frame implements ItemListener {
    int x1,x2,y1,y2;
    Checkbox red,yellow,green;
    CheckboxGroup cbg;
    car(){
        x1=10;
        x2=80;
        y1=300;
        y2=80;
        cbg = new CheckboxGroup();
        red = new Checkbox("Red",cbg,false);
        yellow = new Checkbox("Yellow",cbg,false);
        green = new Checkbox("Green",cbg,false);
        red.addItemListener(this);
        yellow.addItemListener(this);
        green.addItemListener(this);
        add(red);
        add(yellow);
        add(green);
        repaint();
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });
        setSize(600,600);
        setVisible(true);
        setLayout(new FlowLayout());
    }
    public void itemStateChanged(ItemEvent e){
        repaint();
    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawRect(100,70,80,200);
        g.fillRect(100,70,80,200);
        g.setColor(Color.pink);
        g.drawOval(110,80,50,50);
        g.drawOval(110,140,50,50);
        g.drawOval(110,200,50,50);
        g.setColor(Color.cyan);
        g.drawRect(x1,y1,x2,y2);
        g.fillRect(x1,y1,x2,y2);
        if(cbg.getSelectedCheckbox()==red){
            g.setColor(Color.red);
            g.fillOval(110,80,50,50);
        }
        else if(cbg.getSelectedCheckbox()==yellow){
            g.setColor(Color.yellow);
            g.fillOval(110,140,50,50);
        }
        else if(cbg.getSelectedCheckbox()==green){
            g.setColor(Color.green);
            g.fillOval(110,200,50,50);
            if(x1<600){
                x1+=1;
            }
            else{
                x1=10;
                x2=80;
            }
            repaint();
        }
        try{
            Thread.sleep(10);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        

    }   
    public static void main(String args[]){
        car c = new car();
    }    
}
