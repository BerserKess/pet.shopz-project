const form = document.getElementById("forms");
    const container = document.getElementById("container-cards")

    form.addEventListener("submit", (e) => {
        e.preventDefault();

        const animalName = document.getElementById("animal-name");
        const animalType = document.getElementById("animal-type");
        const animalAge = document.getElementById("animal-age");
        const animalOwner = document.getElementById("animal-owner");

        axios.post("/petshopz/add-animal", {
            name: animalName.value,
            type: animalType.value,
            age: parseInt(animalAge.value),
            owner: animalOwner.value
        }).then(response => {
            alert("Animal Cadastrado", response.data);
            listarAnimals(); // atualizar a lista
            form.reset(); // deixar os inputs em branco
        }).catch(error => {
            console.error("Erro ao cadastrar:", error);
        });
    });

    function listarAnimals(){
        axios.get("/petshopz/animals").then(response => {
            const animals = response.data;
            container.innerHTML = "";
            animals.forEach(element => {
                const card = document.createElement("div");
                card.className = "animal-card"

                const title3 = document.createElement("h3");
                title3.textContent = `${element.name}`

                const textType = document.createElement("p");
                const spanType = document.createElement("span");
                spanType.textContent = "Tipo: ";
                textType.appendChild(spanType);
                textType.appendChild(document.createTextNode(element.type));

                const textAge = document.createElement("p");
                const spanAge = document.createElement("span");
                spanAge.textContent = "Idade: ";
                textAge.appendChild(spanAge);
                textAge.appendChild(document.createTextNode(`${element.age} anos`));

                const textOwner = document.createElement("p");
                const spanOwner = document.createElement("span");
                spanOwner.textContent = "Dono: ";
                textOwner.appendChild(spanOwner);
                textOwner.appendChild(document.createTextNode(element.owner));

                const btnDelete = document.createElement("button");
                btnDelete.textContent = "Excluir Animal"
                btnDelete.onclick = () => deleteAnimal(element.id);

                card.append(title3, textType, textAge, textOwner, btnDelete);
                container.appendChild(card)
            });

        });
    }

    function deleteAnimal(id){
        axios.delete(`/petshopz/deletar-animal`, {params: {id: id}}).then(() => {
            alert("Animal excluido com sucesso.");
            listarAnimals();
        }).catch(error => {
            console.error("Erro ao excluir animal", error)
        })
    }

    listarAnimals();