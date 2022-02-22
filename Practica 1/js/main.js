
function CrearEstado(){
    let estado = [];
    for(let i=0; i<2;i++){
        const aleatorio = random();
        (aleatorio === 1) ? estado.push('Limpio') : estado.push('Sucio');
    }
    return estado;
}

function CrearContenedor(){
    ///------- Crear Div Contenedor
    const body = document.querySelector('BODY');
    const contenedor = document.createElement('div');
    contenedor.classList.add('contenedor');
    contenedor.appendChild(CrearDiv());
    contenedor.appendChild(CrearDiv());
    body.appendChild(contenedor);
    agregarImagenes(contenedor);
}

function CrearDiv(){
    const div = document.createElement('div');
    return div;
}

function agregarImagenes(contenedor){
    // const contenedor = document.querySelector('.contenedor');
    const divs = contenedor.querySelectorAll('div');
    const estado = CrearEstado();
    const posicion = random()-1;
    let agente = new Agente(estado, posicion);
    console.log('Desde afuera: ' + estado);

    while(agente.isDirty() === 'Sucio'){
        agente.imprimeEstado();
        agente.run();
    }

    const parrafo = document.querySelector("#movimientos");
    parrafo.innerHTML= 5;

    const par = document.querySelector("#penalizaciones");
    par.innerHTML= agente.movimiento;

    const parr = document.querySelector("#energia");
    parr.innerHTML= 5 - agente.movimiento;

    
    console.log('Cantidad de movimientos ' + agente.movimiento);
    agente.imprimeEstado();
    

    // divs[posicion].appendChild(crearImagen('aspiradora'));
    // for(let i=0; i<estado.length; i++){
    //     if(estado[i] === 'Sucio'){
    //         divs[i].appendChild(crearImagen('basura'));
    //     }
    // }
}

// function crearImagen(img){
//     const imagen = document.createElement('img');
//     imagen.classList.add('imagen');
//     imagen.src = `css/img/${img}.png`;
//     return imagen;
// }


function random(){
    const min =1, max=3;
    return Math.floor(Math.random() * (max - min)) + min;
}

CrearContenedor();

