describe('angularjs homepage todo list', function() {
    it('should have title Google', function () {
    browser.ignoreSynchronization = true;
      browser.get("http://localhost:4200/");
      expect(browser.getTitle()).toEqual("AngularLearning");
});
  it('should have search field', function () {
    browser.ignoreSynchronization = true;
    browser.get("http://localhost:4200/app-employee-list");
    expect(element(by.id("search"))).toBeTruthy();
  });
it('should have salary field', function () {
  browser.ignoreSynchronization = true;
  browser.get("http://localhost:4200/edit-emp-reactive");
  expect(element(by.id("salary"))).toBeTruthy();
});
  it('should have value 1', function () {
    browser.ignoreSynchronization = true;
    browser.get("http://localhost:4200/quantity-selector");
    element(by.id("plus")).click();    
    expect(element(by.css("input")).getAttribute('value')).toEqual("1");
  });
});
