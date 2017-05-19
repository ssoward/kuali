describe('Setting up tests with Jasmine', function(){

    it('should be true', function() {
        expect(true).toBe(true);
    });

    it('should see the source file', function() {
        expect(compliment()).toBe('hello world');
    });

    it('should see the source file', function() {
        expect(urls.school('scott', 'maggie')).toBe('http://utah.edu/scott/maggie');
    });


    it('should see the source file', function() {
        expect(urls.home(['isabel', 'isaac', 'noah'])).toBe('http://lds.org/isabel/isaac/noah/');
    });
});
