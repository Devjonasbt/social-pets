funciton tempo(request, response) {
    const dynamicDate = newDate();

    response.json({
        date: dynamicDate.toGMTString()
    })
}

export default tempo;

