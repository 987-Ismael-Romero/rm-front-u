package rmFrontU;

import javax.swing.JPanel;
/*
 * @Author: Ismael Romero Morales
 * Github: https://github.com/987-Ismael-Romero
 *
 * NOTE: only 3 elements
 * */
public class rmSliderAutomatic implements Runnable {

    private Boolean threadEnd = true;
    private Boolean auxSlide = true;
    private int duration;
    private int sleep;
    private int width;
    private int auxWidth;
    private int elements;
    private int XL, YL;
    private int Change = 1;

    private JPanel componentSlide;

    public rmSliderAutomatic(JPanel componentSlide){
        this.componentSlide = componentSlide;
    }

    public void configSlide(int duration, int sleep, int width, int elements, int XL, int YL){
        this.duration = duration;
        this.sleep = sleep;
        this.width = width * (elements-1);
        this.elements = elements;
        this.auxWidth = this.width;

        this.XL = XL;
        this.YL = YL;

        new Thread(this).start();
    }

    protected void diplacementSlide(int XL, int YL){
        this.componentSlide.setLocation(XL, YL);
    }

    @Override
    public void run() {
        while(threadEnd){
            try{
                if(Change == 1){
                    while(auxSlide.equals(true)){
                        if (this.XL != -this.auxWidth){
                            if(this.XL == -(this.auxWidth/2)){
                                Thread.sleep(this.sleep);
                            }else {
                                Thread.sleep(this.duration);
                                diplacementSlide(XL, YL);
                            }
                            this.XL -= 1;
                            this.width -= 1;
                        }else{
                            Thread.sleep(this.sleep);
                            auxSlide = false;
                            Change = 0;
                        }
                    }
                }else if(Change == 0){
                    while (auxSlide.equals(false)){
                        if (this.XL != 0){
                            if (this.XL == -(this.auxWidth/2)) {
                                Thread.sleep(this.sleep);
                            }else{
                                Thread.sleep(this.duration);
                                diplacementSlide(XL, YL);
                            }
                            this.XL +=1;
                            this.width +=1;
                        }else {
                            Thread.sleep(this.sleep);
                            auxSlide = true;
                            Change = 1;
                        }
                    }
                }
            }catch (InterruptedException ex){
                System.out.println(ex.getCause());
                System.out.println(ex.getMessage());
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
}
