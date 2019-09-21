import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calc  extends JFrame implements ActionListener {
   static JButton one, two, three, four, five, six, seven, eight,nine, zero,dot,times,sub,add,div,equal,clear;
   static JTextField  textField;
   static JLabel warning;
   static JPanel p1, p2;  
   static String  finalNum;
   static boolean operator = false;
     
    public static void main(String args[]){
      Calc a = new Calc();
      a.setTitle("My calculator");
      a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   Calc(){
      
       one=new JButton("1");
       two=new JButton("2");
       three=new JButton("3");
       four=new JButton("4");
       five=new JButton("5");
       six=new JButton("6");
       seven=new JButton("7");
       eight =new JButton("8");
       nine=new JButton("9");
       zero = new JButton("0");
       dot=new JButton(".");
       sub=new JButton("-");
       times=new JButton("*");
       div =new JButton("/");
       add = new JButton("+");
       equal = new JButton("=");
       clear = new JButton("clear");
      
       textField = new JTextField(20);
       warning = new JLabel();
     
      JPanel p2 =new JPanel();
      JPanel p1 = new JPanel();
      
      p2.setLayout (new GridLayout(4,4) );
      p1.setLayout (new FlowLayout() );
     
     add(p2,BorderLayout.CENTER);
     add(p1,BorderLayout.SOUTH);
   
     setVisible(true);
     setSize(600,400);
     
      p1.add(textField);
      p1.add(clear);
      p1.add(warning);
     
      p2.add(seven);
      p2.add(eight);
      p2.add(nine);
      p2.add(add);
      p2.add(four);
      p2.add(five);
      p2.add(six);
      p2.add(sub);
      p2.add(one);
      p2.add(two);
      p2.add(three);
      p2.add(times);
      p2.add(zero);
      p2.add(dot);
      p2.add(equal);
      p2.add(div);     
   
      one.addActionListener(this);
      two.addActionListener(this);
      three.addActionListener(this);
      four.addActionListener(this);
      five.addActionListener(this);
      six.addActionListener(this);
      seven.addActionListener(this);
      eight.addActionListener(this);
      nine.addActionListener(this);
      zero.addActionListener(this);
      dot.addActionListener(this);

                
  
      OperatorClass obj=new OperatorClass();
      
      clear.addActionListener(obj);
      add.addActionListener(obj);
      sub.addActionListener(obj);
      div.addActionListener(obj);
      times.addActionListener(obj);
      equal.addActionListener(obj);
     
  
   }
   
     
   public void actionPerformed ( ActionEvent e){
   
   String KeyboardNumber = e.getActionCommand();
   if(operator == true)
   textField.setText("");
   
   
   finalNum = textField.getText() + KeyboardNumber;
   textField.setText(finalNum);
   operator = false;
   OperatorClass.checkOperator = false;
   }
 }

   class OperatorClass  implements ActionListener{
   static double total;
   static String sysmbol,displayTotal;
   static String next;
   static String prev;
   static boolean doubleOperator = false, checkOperator = false;
   
      public void actionPerformed ( ActionEvent j ){
      double number1;
      
       next = j.getActionCommand();
       
      if(next != prev){
         Calc.operator=true;
         number1 = Double.parseDouble(Calc.finalNum);
            if(doubleOperator == false){
            total = total + number1;
            doubleOperator = true; 
            }
                   
            if(next == "clear"){
            total = 0;
            doubleOperator = false;
            Calc.operator = false;
            Calc.textField.setText("");
            }
               
              if(doubleOperator == true && next != prev){
                  if(prev == "+"){
                  total = total + number1;   
                  displayTotal = Double.toString(total);
                   Calc.textField.setText(displayTotal);  
                  }
                  else if(prev == "-"){
                  total = total - number1; 
                  displayTotal = Double.toString(total);
                  Calc.textField.setText(displayTotal);   
                  }   
                  else if(prev == "*"){
                  total = total * number1;  
                  displayTotal = Double.toString(total);
                   Calc.textField.setText(displayTotal);  
                   }    
                  else if(prev == "/"){
                  total = total / number1; 
                  displayTotal = Double.toString(total);
                   Calc.textField.setText(displayTotal);   
                   } 
                  else if(prev == "="){
                  total = total;
                  displayTotal = Double.toString(total);
                   Calc.textField.setText(displayTotal); 
                  }
               }                      
           prev=next;
        }
        else
        Calc.warning.setText("Can't choose an operator again!");
 
      }
   }
   
              
   

   





