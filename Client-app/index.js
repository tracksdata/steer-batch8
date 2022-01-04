fetch("http://localhost:9091/api/products")
.then(response => response.json())
.then(products=>{
    console.log(products);
})