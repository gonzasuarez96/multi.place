function getSessionStorageLocation(){
    if(typeof window !== "undefined"){
        
    const locationJ = sessionStorage.getItem("location");
    const location = JSON.parse(locationJ);
    return location;
    }
}

function getSessionStorageToken(){
    if(typeof window !== "undefined"){
        const token = sessionStorage.getItem('token');
        return token
    }
}

export { getSessionStorageLocation , getSessionStorageToken}