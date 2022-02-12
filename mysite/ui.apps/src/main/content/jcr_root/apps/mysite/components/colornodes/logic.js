use(function () {
    var res = resource.getResourceResolver().getResource('/content/mysite/my-options/colornodes');
    return {
        result: res
    };
});