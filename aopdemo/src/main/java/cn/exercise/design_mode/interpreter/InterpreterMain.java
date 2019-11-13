package cn.exercise.design_mode.interpreter;

public class InterpreterMain {

    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        System.out.println("上海滩：");
        context.setText("T 500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 T 1000 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 ");
        Expression expression = null;
        while (context.getText().length()>0){
            String str = context.getText().substring(0,1);
            switch (str){
                case "O":{
                    expression = new Scale();
                    break;
                }
                case "C":{
                    expression = new Note();
                    break;
                }
                case "D":{
                    expression = new Note();
                    break;
                }
                case "E":{
                    expression = new Note();
                    break;
                }
                case "F":{
                    expression = new Note();
                    break;
                }
                case "G":{
                    expression = new Note();
                    break;
                }
                case "A":{
                    expression = new Note();
                    break;
                }
                case "B":{
                    expression = new Note();
                    break;
                }
                case "P":{
                    expression = new Note();
                    break;
                }
                case "T":{
                    expression = new Speed();
                }
            }
            expression.interpret(context);
        }


    }


}
