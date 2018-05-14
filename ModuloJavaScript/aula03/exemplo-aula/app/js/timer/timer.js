let counterValue = 0
setInterval(()=>{
    document.getElementById('counter').innerHTML=++counterValue
},1000)

setTimeout(()=>{
    console.log('TIMEOUT')
},2000)

