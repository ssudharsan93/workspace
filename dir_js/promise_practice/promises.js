const request = require('native-request');


const testPromise = () => { 
    return new Promise( (resolve, reject) => {
        request.get('https://jsonplaceholder.typicode.com/todos/1', (err, data) => {
            if ( err ) { reject(err); }
            resolve(data);
        });
    });
};

testPromise()
.then(response => {
    console.log("My First Promise yay!!!!");
    console.log(response)
}) //.then allows you to handle the data that is returned from the promise.
.catch(err => { 
    console.log("Whoopsie! \n\n")
    console.log(err);
}); // .catch block handles errors