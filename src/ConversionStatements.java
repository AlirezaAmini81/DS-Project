

public  abstract class ConversionStatements extends Statement implements Convertible{


    public static int getPriority(String str){
        if(str.matches("[?]")){
            return 5;
        }else if(str.matches("sin")||str.matches("cos")||str.matches("tan")||str.matches("cot")){
            return 4;
        }else if(str.matches("\\^")){
            return 3;
        }else if(str.matches("[/*]")){
            return 2;
        }else if(str.matches("[+-]")){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static boolean infixEvaluation(String  input){
        boolean isInfix = true;
        if(countOccurrence(input,")") != countOccurrence(input,"(") ){
            isInfix = false;
        }
        if(input.matches(".*[0-9A-Za-z]+[ ][0-9A-Za-z]+.*")){
            isInfix = false;
            System.out.println(input);
        }
        if(input.matches(".*[(][+*^/]+.*") ){
            isInfix = false;
        }
        if(input.matches(".*[0-9A-Za-z][(]+.*") && !input.matches(".*sin[(]+.*") &&
            !input.matches(".*cos[(]+.*") && !input.matches(".*tan[(]+.*") && !input.matches(".*cot[(]+.*")){
            isInfix = false;
        }
        if(input.matches(".*[+^\\-*/]+[)].*")){
            isInfix = false;
        }
        return isInfix;
    }

    public static boolean postfixEvaluation(String input){
        boolean isPostfix = true;
        if(!input.matches("[0-9A-Za-z]+[ ][0-9A-Za-z]+.*") && !input.matches("[0-9A-Za-z]+[ ][?].*") ){
            isPostfix = false;
        }
        if(input.contains("(") || input.contains(")")){
            isPostfix = false;
        }
        return isPostfix;
    }

    public static boolean prefixEvaluation(String input){
        boolean isPrefix = true;
        if(!input.matches("[+*\\-^/?(sin)(cos)(tan)(cot)]+.*") ){
            isPrefix = false;
        }
        if(input.contains("(") || input.contains(")")){
            isPrefix= false;
        }
        return isPrefix;
    }

    public static int countOccurrence (String string, String substring){
        int count = 0, fromIndex = 0;
        while((fromIndex = string.indexOf(substring, fromIndex)) != - 1){
            count ++;
            fromIndex ++;
        }
        return count;
    }

    public static boolean isFunction(String str){
        boolean isFunction = false;
        if( str.matches("sin")|| str.matches("cos")|| str.matches("tan")|| str.matches("cot")){
            isFunction = true;
        }
        return isFunction;
    }
}
