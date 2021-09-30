
import java.util.Stack;
import java.util.*;

public class Notation {

    static int Prec(char objCh) {
        switch (objCh) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }


    public static String convertInfixToPostfix(String complexInfix) {
        String objResultInfo = new String("");
        Stack<Character> objStackInfo = new Stack<>();
        for (int i = 0; i < complexInfix.length(); ++i) {
            char c = complexInfix.charAt(i);
            if (Character.isLetterOrDigit(c))
                objResultInfo += c;
            else if (c == '(')
                objStackInfo.push(c);
            else if (c == ')') {
                while (!objStackInfo.isEmpty() && objStackInfo.peek() != '(')
                    objResultInfo += objStackInfo.pop();
                if (!objStackInfo.isEmpty() && objStackInfo.peek() != '(')
                    return "Info : Invalid Expression";
                else
                    objStackInfo.pop();
            } else {
                while (!objStackInfo.isEmpty() && Prec(c) <= Prec(objStackInfo.peek()))
                    objResultInfo += objStackInfo.pop();
                objStackInfo.push(c);
            }
        }
        while (!objStackInfo.isEmpty())
            objResultInfo += objStackInfo.pop();
        return objResultInfo;
    }


    public static String convertPostfixToInfix(String complexPostfix) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <complexPostfix.length() ; i++) {
            char c = complexPostfix.charAt(i);

            if(c=='*'||c=='/'||c=='^'||c=='+'||c=='-' ){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s2+c+s1+")";
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        String result=stack.pop();
        return result;
    }

    public static double evaluatePostfixExpression(String complexPostfix) {
        char[] objTokens = complexPostfix.toCharArray();
        Stack<Integer> objValues = new Stack<Integer>();
        Stack<Character> objOps = new Stack<Character>();
        for (int iObj = 0; iObj < objTokens.length; iObj++) {
            if (objTokens[iObj] == ' ')
                continue;
            if (objTokens[iObj] >= '0' && objTokens[iObj] <= '9') {
                StringBuffer objSbuf = new StringBuffer();
                while (iObj < objTokens.length && objTokens[iObj] >= '0'&& objTokens[iObj] <= '9')
                    objSbuf.append(objTokens[iObj++]);
                objValues.push(Integer.parseInt(objSbuf.toString()));
            }
            else if (objTokens[iObj] == '(')
                objOps.push(objTokens[iObj]);
            else if (objTokens[iObj] == ')') {
                while (objOps.peek() != '(')
                    objValues.push(apply_Op(objOps.pop(), objValues.pop(), objValues.pop()));
                objOps.pop();
            }
            else if (objTokens[iObj] == '+' || objTokens[iObj] == '-' || objTokens[iObj] == '*'
                    || objTokens[iObj] == '/') {
                while (!objOps.empty() && has_Precedence(objTokens[iObj], objOps.peek()))
                    objValues.push(apply_Op(objOps.pop(), objValues.pop(), objValues.pop()));
                objOps.push(objTokens[iObj]);
            }
        }
        while (!objOps.empty())
            objValues.push(apply_Op(objOps.pop(), objValues.pop(), objValues.pop()));
        return objValues.pop();
    }
    public static boolean has_Precedence(char obj_op1, char obj_op2) {
        if (obj_op2 == '(' || obj_op2 == ')')
            return false;
        if ((obj_op1 == '*' || obj_op1 == '/') && (obj_op2 == '+' || obj_op2 == '-'))
            return false;
        else
            return true;
    }
    public static int apply_Op(char obj_op, int obj_b, int obj_a) {
        switch (obj_op) {
            case '+':
                return obj_a + obj_b;
            case '-':
                return obj_a - obj_b;
            case '*':
                return obj_a * obj_b;
            case '/':
                if (obj_b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero exception");
                return obj_a / obj_b;
        }
        return 0;
    }

    public static double evaluateInfixExpression(String infixExpr) {
        return Double.parseDouble(null);
    }
}
