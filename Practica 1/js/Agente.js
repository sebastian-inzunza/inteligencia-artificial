
class Agente{
    
    constructor(estado, posicion){
        this.estado = estado;
        this.posicion = posicion;
        this.movimiento = 0;
    }

    run(){
        if(this.estado[this.posicion] === 'Sucio'){
            this.estado[this.posicion] = 'Limpio';
            this.movimiento++;
            if(this.isDirty() === 'Sucio'){
                console.log('Limpie paso a siguiente');
                this.siguiente();
            }
        }
        else{
            console.log('Aca');
            this.siguiente();  
        }
        console.log(this.estado);
    }
    // si es true es por que hay otro estado sucio
    isDirty(){
       return this.estado.find(element => element === 'Sucio');
    }

    siguiente(){
        this.movimiento++;
        if(this.posicion === 0){
            console.log('incremente');
            this.posicion = 1;
            
        }else{
            console.log('decremente');
            this.posicion = 0;
        }
    }

    imprimeEstado(){
        const contenedor = document.querySelector('.contenedor');
        const divs = contenedor.querySelectorAll('div');
        divs[this.posicion].appendChild(this.crearImagen('aspiradora'));
        for(let i=0; i<this.estado.length; i++){
            if(this.estado[i] === 'Sucio'){
                divs[i].appendChild(this.crearImagen('basura'));
            }
        }
    }

    crearImagen(img){
        const imagen = document.createElement('img');
        imagen.classList.add('imagen');
        imagen.src = `../css/img/${img}.png`;
        return imagen;
    }
}