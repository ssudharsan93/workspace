const imports = require('./sum');
const sum = imports.sum;
const myFunction = imports.myFunction;
const fetchData = imports.fetchData;
const fetchPromise = imports.fetchPromise;

test('adds 1 + 2 to equal 3', () => { 
    expect(sum(1,2)).toBe(3);
});


test('two plus two is four', () => {
    expect(2 + 2).toBe(4);
});

test('string two plus string three is string twenty-three', () => {
    expect("2" + "3").toBe("23");
});

test('object assignment', () => {
    const data = { one : 1 };
    data['two'] = 2;

    expect(data).toEqual({ one: 1, two: 2 });
});

test('null is falsy', () => { 
    const n = null;
    expect(n).toBeFalsy();
});

test('zero is falsy', () => { 
    const n = 0;
    expect(n).toBeFalsy();
});

test('one is truthy', () => { 
    const n = 1;
    expect(n).toBeTruthy();
});

test('object is truthy', () => {
    const data = { one : 1 };
    data['two'] = 2;

    expect(data).toBeTruthy();
});


test('throws on invalid input', () => { 
    expect(() => {
            myFunction("myString");
    }).toThrow();
});

test('the data is peanut butter', done => {
    function callback(data){ 
        try { 
            expect(data).toBe('peanut butter');
            done();
        } catch(error) { 
            done(error);
        }
    }

    fetchData(callback);
});

test('the data is peanut butter for promise', () => { 
    return expect(fetchPromise()).resolves.toBe('peanut butter');
});

// basic way to test if the promise is rejected.
//test('the fetch fails with an error', () => { 
//    return expect(fetchPromise()).rejects.toThrow('error');
//});

test('the data is peanut butter with async/awaits', async () => { 
    const data = await fetchPromise();
    expect(data).toBe('peanut butter');
});

test('mock implementation of a basic function', () => { 
    const mock = jest.fn(x => 42 + x); // returns 42 + whatever value we give it.
    expect(mock(1)).toBe(43);
    expect(mock).toHaveBeenCalledWith(1);
})

test('spying on a method of an object', () => { 
    const video = { 
        play() { 
            return true;
        },
    };

    const spy = jest.spyOn(video, 'play');
    video.play();

    expect(spy).toHaveBeenCalled();
    spy.mockRestore();
})