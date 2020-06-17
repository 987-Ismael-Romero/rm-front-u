package rmFrontU;

import javax.swing.JPanel;
/*
 * @Author: Ismael Romero Morales
 * Github: https://github.com/987-Ismael-Romero
 *
 * */
public class rmDisplacementX implements Runnable {

    private int XL = 0;                     //Variable para determinar el desplazamiento en eje x
    private int initialXL = 0;              //Varible donde se define la posicion inicial del elemento a mover en X
    private int initialYL = 0;              //Variable que determina el posicion inicial del elemento en Y, se respeta su posicion
    private int initialWidth = 0;           //Variable para determinar el ancho inicial del elemento
    private int initialHeight = 0;          //Variable para determinar el alto inicial del elemento
    private int deltaWidth = 0;             //Variable para determinar el crecimiento del elemento en ancho
    private int typeDisplacement;           //Variable para definir el tipo de movimiento
    private int time = 0;                   //Tiempo de transicion

    private Boolean threadEnd = true;       //Variable utilizada para finalizar el thread
    private JPanel componentToMove;

    public rmDisplacementX(JPanel panel, int XL, int initialXL, int initialYL,int deltaWidth, int time, int typeDisplacement){
        //Inicializacion de todas las variables
        this.componentToMove = panel;
        this.XL = XL;
        this.initialXL = initialXL;
        this.initialYL = initialYL;
        this.deltaWidth = deltaWidth;
        this.time = time;
        this.typeDisplacement = typeDisplacement;
        this.initialWidth = this.componentToMove.getWidth();
        this.initialHeight = this.componentToMove.getHeight();

        new Thread(this).start();
    }

    @Override
    public void run() {
        while (threadEnd){
            if (this.initialXL != this.XL){
                try{
                    Thread.sleep(this.time);
                    switch (typeDisplacement){
                        case 1:     //Este caso desplaza el componente en el eje x deseignado
                            this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                            this.componentToMove.setLocation(this.initialXL, this.initialYL);
                            initialXL -= 1;
                            break;
                        case 2:     //Este caso desplaza al componente a su eje original
                            this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                            this.componentToMove.setLocation(this.initialXL, this.initialYL);
                            initialXL += 1;
                            break;
                        case 3:     //Desplaza el componente en el eje x desiganado y asu ves aumenta el tamño
                            if((deltaWidth+initialWidth) != this.initialWidth) {
                                this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                                this.componentToMove.setLocation(this.initialXL, this.initialYL);
                                initialXL -= 1;
                                initialWidth+=1;
                            }
                            break;
                        case 4:     //Desplaza el componente a su eje original  y asu ves aumenta el disminuye su tamño
                            if((deltaWidth-initialWidth) != this.initialWidth) {
                                this.componentToMove.setSize(this.initialWidth, this.initialHeight);
                                this.componentToMove.setLocation(this.initialXL, this.initialYL);
                                initialXL += 1;
                                initialWidth-=1;
                            }
                            break;
                        default:
                            System.out.println("No hay un desplazamiento con coincidencia: "+ this.typeDisplacement);
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
