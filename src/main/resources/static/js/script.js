

let sortStates={}
function sortTable(columnIndex) {
    console.log(columnIndex)

    if (sortStates[columnIndex] === undefined) {
        sortStates[columnIndex] = 'asc';
    }

    let body = document.getElementsByTagName('tbody')[0];
    let rows = Array.from(body.getElementsByTagName("tr"));
    let headers = document.getElementsByTagName("th");


    let sortedRows = rows.sort((rowA, rowB) => {
        let cellA = rowA.cells[columnIndex].innerText;
        let cellB = rowB.cells[columnIndex].innerText;

        let sortDirection = sortStates[columnIndex] === 'asc' ? 1 : -1;

        if (!isNaN(cellA) && !isNaN(cellB)) {
            return sortDirection * (Number(cellA) - Number(cellB));
        }
        return sortDirection * (cellA.localeCompare(cellB));
    })

    for (const header of headers) {
        let arr = header.innerText.split(' ');
        header.innerText = arr[0];


    }


    if (sortStates[columnIndex] === 'asc') {
        sortStates[columnIndex] = 'desc'
        headers[columnIndex].innerText = headers[columnIndex].innerText + ' ⬆️'
    } else {
        sortStates[columnIndex] = 'asc'
        headers[columnIndex].innerText = headers[columnIndex].innerText + ' ⬇️'

    }

    sortedRows.forEach(row => {
        body.appendChild(row)
    })
}