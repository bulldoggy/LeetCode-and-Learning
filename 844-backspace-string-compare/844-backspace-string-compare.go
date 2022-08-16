func backspaceCompare(s string, t string) bool {
    sPos := len([]rune(s)) - 1
    tPos := len([]rune(t)) - 1
    sBack := 0
    tBack := 0
    
    for sPos >= 0 || tPos >= 0 {
        for sPos >= 0 {
            if s[sPos] == '#' {
                sBack++
                sPos--
            } else if sBack > 0 {
                sBack--
                sPos--
            } else {
                break
            }
        }
        
        for tPos >= 0 {
            if t[tPos] == '#' {
                tBack++
                tPos--
            } else if tBack > 0 {
                tBack--
                tPos--
            } else {
                break
            }
        }
        
        if (sPos>=0) != (tPos>=0) {
            return false
        }
        
        if sPos >= 0 {
            if s[sPos] != t[tPos] {
                return false
            }
        }
        
        sPos--
        tPos--
    }
    
    return true;
}