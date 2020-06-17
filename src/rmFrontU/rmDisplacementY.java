package rmFrontU;

import javax.swing.JPanel;
/*
 * @Author: Ismael Romero Morales
 * Github: https://github.com/987-Ismael-Romero
 *
 * */
public class rmDisplacementY implements Runnable{

    private int YL = 0;                     //Variable para determinar el desplazamiento en eje y
    private int initialXL = 0;              //Variable que determina el posicion inicial del elemento en X, se respeta su posicion
    private int initialYL = 0;              //Varible donde se define la posicion inicial del elemento a mover en Y
    private int initialWidth = 0;           //Variable para determinar el ancho inicial del elemento
    private int initialHeight = 0;          //Variable para determinar el alto inicial del elemento
    private int deltaHeigth = 0;            //Variable para determinar el crecimiento del elemento en ancho
    private int typeDisplacement;           //Variable para definir el tipo de movimiento
    private int time = 0;                   //Tiempo de transicion

    private Boolean threadEnd = true;       //Variable utilizada para finalizar el thread
    private JPanel componentToMove;

    public rmDisplacementY(JPanel panel, int YL, int initialXL, int initialYL, int deltaHeigth, int time, int typeDisplacement){
        this.componentToMove = panel;
        this.YL = YL;
        this.initialYL = initialYL;
        this.initialXL = initialXL;
        this.deltaHeigth = deltaHeigth;
        this.time = time;
        this.typeDisplacement = typeDisplacement;
        this.initialWidth = this.componentToMove.getWidth();
        this.initialHeight = this.componentToMove.getHeight();

        new Thread(this).start();
    }

    @Override
    public void run() {
        while(threadEnd){
            if(this.initialYL != this.YL){
                try{
                    Thread.sleep(this.time);
                    switch (typeDisplacement){
                        case 1:
                            this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                            this.componentToMove.setLocation(this.initialXL, initialYL);
                            initialYL -= 1;
                            break;
                        case 2:
                            this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                            this.componentToMove.setLocation(this.initialXL, initialYL);
                            initialYL += 1;
                            break;
                        case 3:
                            if((deltaHeigth+initialHeight) != this.initialHeight) {
                                this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                                this.componentToMove.setLocation(this.initialXL, this.initialYL);
                                initialYL -= 1;
                                initialHeight+=1;
                            }
                            break;
                        case 4:
                            if((deltaHeigth-initialHeight) != this.initialHeight) {
                                this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                                this.componentToMove.setLocation(this.initialXL, this.initialYL);
                                initialYL += 1;
                                initialHeight-=1;
                            }
                            break;
                        default:
                            System.out.println("No hay un desplazamiento con coincidencia: " + typeDisplacement);
                            break;
                    }
                }catch (InterruptedException ex){
                    System.out.println("cause: "+ex.getCause());
                    System.out.println("Mensaje: "+ex.getMessage());
                    System.out.println("Localizacion: "+ex.getLocalizedMessage());
                }

            }else{
                threadEnd = false;
            }
        }
    }
}
