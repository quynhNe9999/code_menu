        const tableConfig = {
            "Customer": {
                "title": "Customer Management",
                "headers": ["ID", "Name", "Email", "Phone", "Address"],
                "fields": ["id", "name", "email", "phone", "address"]
            },
            "Product": {
                "title": "Product Management",
                "headers": ["ID", "Name", "Category", "Price", "Stock"],
                "fields": ["id", "name", "category", "price", "stock"]
            },
            // Add more configurations as needed
        };

        function loadTableConfig(entity) {
            const config = tableConfig[entity];
            document.getElementById("table-title").innerText = config.title;

            const tableHeaders = document.getElementById("table-headers");
            tableHeaders.innerHTML = '';
            config.headers.forEach(header => {
                const th = document.createElement("th");
                th.innerText = header;
                tableHeaders.appendChild(th);
            });

            addRow();
        }

        function addRow() {
            const entity = document.getElementById("table-title").innerText.split(" ")[0];
            const config = tableConfig[entity];
            const tableBody = document.getElementById("table-body");

            const row = document.createElement("tr");
            config.fields.forEach(field => {
                const td = document.createElement("td");
                const input = document.createElement("input");
                input.type = "text";
                input.name = field;
                input.classList.add("form-control");
                td.appendChild(input);
                row.appendChild(td);
            });

            tableBody.appendChild(row);
        }

        // Example to load Customer form
        document.addEventListener("DOMContentLoaded", () => {
            loadTableConfig("Customer");
        });

        // Handle form submission
        document.getElementById("form-table").addEventListener("submit", function(event) {
            event.preventDefault();
            const formData = new FormData(this);
            const data = {};
            formData.forEach((value, key) => {
                if (!data[key]) {
                    data[key] = [];
                }
                data[key].push(value);
            });

            console.log(data); // Process the data as needed, e.g., send to server
        });

document.getElementById("form-table").addEventListener("submit", function(event) {
    event.preventDefault();
    const formData = new FormData(this);
    const data = {};
    formData.forEach((value, key) => {
        if (!data[key]) {
            data[key] = [];
        }
        data[key].push(value);
    });

    fetch('/api/customers', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
});