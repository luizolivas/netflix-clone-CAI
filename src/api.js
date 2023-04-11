const API_KEY = '6e2663b6af645802a53f1e84b481e7f6'

const API_DNS = "https://api.themoviedb.org/3/"

export const categories = [
    {
        name: "trending",
        title: "Em Alta",
        path: "/trending/all/week?api_key="+API_KEY+"&language=pt-BR"
    },
    {
        name: "comedy",
        title: "Comédia",
        path: "/trending/all/week?api_key="+API_KEY+"&language=pt-BR"
    },
    {
        name: "romances",
        title: "Romances",
        path: "/trending/all/week?api_key="+API_KEY+"&language=pt-BR"
    },
    {
        name: "documentaries",
        title: "Documentários",
        path: "/discover/tv/api_key="+API_KEY+"&with_genres=99"
    }
]

export const getMovies = async (path) =>{
    try{
        let url = API_DNS + path

        const response = fetch(url)

        return (await response).json()
    }catch(error){
        console.log(error)
    }
} ;