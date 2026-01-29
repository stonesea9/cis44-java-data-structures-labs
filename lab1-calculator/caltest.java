public class caltest {

    private double valuenum;        // 当前屏幕显示的值
    private String operator;       // 待执行运算符: + - * / 或 null
    private boolean ifnum;
    private boolean error;
    public caltest() {
        clear();
    }
    public void clear() {
        valuenum = 0.0;
        operator = null;
        ifnum = true;
        error = false;
    }
    public double getValuenum() {
        return valuenum;
    }

    public boolean isError() {
        return error;
    }

    public void inputNumber(double x) {
        if (error) return;

        if (ifnum) {
            if (operator == null) {
                valuenum = x;
            } else {
                switch (operator) {
                    case "+" -> valuenum = valuenum + x;
                    case "-" -> valuenum = valuenum - x;
                    case "*" -> valuenum = valuenum * x;
                    case "/" -> {
                        if (x == 0.0) {
                            error = true;
                            return;
                        }
                        valuenum = valuenum / x;
                    }
                }
                operator = null;
            }
            ifnum= false;
        } else {
            // 连续输入两个数字时，直接替换显示
            valuenum = x;
        }
    }

    public void inputOperator(String op) {
        if (error) return;

        if (op.equals("=")) {
            operator = null;
            ifnum = true;
        } else {
            operator = op;
            ifnum = true;
        }
    }
    }


