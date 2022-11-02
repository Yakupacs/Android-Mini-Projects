package com.example.calculator;

public class Calculate {
    private float num1, num2;

    public Calculate(float num1, float num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public float topla()
    {
        return num1 + num2;
    }

    public float cikar()
    {
        return num1 - num2;
    }

    public float carp()
    {
        return num1 * num2;
    }

    public float bol()
    {
        return num1 / num2;
    }

    public float result(String islem)
    {
        switch (islem)
        {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
