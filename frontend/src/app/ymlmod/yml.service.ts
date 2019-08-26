import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {YmlPostDto, YmlPostResultDto} from "./yml.model";

@Injectable({
  providedIn: 'root'
})
export class YmlService {

  constructor(private http: HttpClient) {
  }

  postYml(ymlPostDto: YmlPostDto): Observable<YmlPostResultDto> {
    return this.http.post<YmlPostResultDto>("/api/yml", ymlPostDto);
  }

}
