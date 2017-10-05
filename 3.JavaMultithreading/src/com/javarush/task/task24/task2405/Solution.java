package com.javarush.task.task24.task2405;

/* 1. Восстанови логику метода someAction для поля solutionAction.
2. Пример вывода смотри в комментарии к методу main.
3. Подсказка: метод someAction анонимного класса поля solutionAction должен вызвать метод сабкласса FirstClass,
если param > 0, иначе вызвать метод сабкласса SecondClass.
Black box
*/
public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Changes can be here
        //!!!!! Изменения могут быть тут


        public void someAction() {
            while (param > 0)
                System.out.println(param--);
            if (param == 0)
                new FirstClass(){
                    @Override
                    public Action getDependantAction() {
                        super.someAction();
                        return new Action() {
                            @Override
                            public void someAction() {
                            }
                        };
                    }
                }.someAction();
            new SecondClass(){
                @Override
                public void someAction() {
                    super.someAction();
                    sb = new StringBuilder(SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1,SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.length()) + param);
                    System.out.println(sb.toString());
                }
            }.someAction();
            //!!!!! All changes have to be here
            //!!!!! Все изменения должны быть только тут
        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
